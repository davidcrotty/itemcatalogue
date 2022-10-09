package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.model.Configuration

class ItemRepositoryImpl(
    private val itemDataSource: ItemDataSource,
    private val itemCache: ItemCacheDataSource,
    private val config: Configuration
) : ItemRepository {
    override suspend fun getItems(): ItemRepository.ItemListStatus {
        val itemData = try {
            itemDataSource.fetchAfter(itemCache.getLastID()?.value, config.pageLimit)
        } catch (e: ContentNotFound) {
            return ItemRepository.ItemListStatus.UnrecoverableError
        } catch (e: ContentFailedToFetch) {
            return ItemRepository.ItemListStatus.RecoverableError
        }

        val items = itemData.map { dto ->
            val id = ID(dto.id)
            val item = Item(
                id = id,
                url = dto.thumbnail,
                type = dto.type,
                title = dto.caption,
                description = dto.description
            )
            this.itemCache.setLastID(id)
            item
        }

        itemCache.storeItems(items)

        return ItemRepository.ItemListStatus.Available(itemCache.fetchStoredItems())
    }

    override suspend fun getItem(id: String): ItemRepository.ItemStatus {
        TODO("Not yet implemented")
    }
}