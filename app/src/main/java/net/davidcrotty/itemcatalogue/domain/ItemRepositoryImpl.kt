package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.model.PagingConfiguration
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteItemDataSource: RemoteItemDataSource,
    private val itemCache: ItemCacheDataSource,
    private val config: PagingConfiguration
) : ItemRepository {
    override suspend fun getItems(): ItemRepository.ItemListStatus {
        val itemData = try {
            remoteItemDataSource.fetchAfter(itemCache.getLastID()?.value, config.pageLimit)
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
                subType = dto.subtype,
                title = dto.caption,
                description = dto.description,
                element = dto.damageType
            )
            this.itemCache.setLastID(id)
            item
        }

        itemCache.storeItems(items)

        return ItemRepository.ItemListStatus.Available(itemCache.fetchStoredItems())
    }

    override suspend fun getItem(id: String): ItemRepository.ItemStatus {
        return when (val result = itemCache.fetchItem(ID(id))) {
            is ItemCacheDataSource.CacheResult.Hit -> {
                ItemRepository.ItemStatus.Available(result.item)
            }
            is ItemCacheDataSource.CacheResult.Miss -> {
                ItemRepository.ItemStatus.Unavailable
            }
        }
    }
}