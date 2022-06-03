package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import net.davidcrotty.itemcatalogue.data.item.exception.ServerError
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.model.Configuration

class ItemRepositoryImpl(
    private val itemDataSource: ItemDataSource,
    private val indexCache: ItemCacheDataSource,
    private val config: Configuration
) : ItemRepository {
    override suspend fun getItems(): ItemRepository.ItemStatus {
        // two successful calls should return different lists
        val itemData = try {
            itemDataSource.fetchAfter("next id", config.pageLimit)
        } catch (e: ContentNotFound) {
            return ItemRepository.ItemStatus.Unavailable
        } catch (e: ServerError) {
            return ItemRepository.ItemStatus.Unavailable
        }

        val items = itemData.map { dto ->
            Item(
                id = ID(dto.id),
                url = dto.thumbnail,
                type = dto.type,
                title = dto.caption,
                description = dto.description
            )
        }

        return ItemRepository.ItemStatus.Available(items)
    }
}