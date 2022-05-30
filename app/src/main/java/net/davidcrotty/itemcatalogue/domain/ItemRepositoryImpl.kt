package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource,
                        private val indexCache: ItemCacheDataSource
) : ItemRepository {
    override suspend fun getItems(): List<Item> {
        // two succesful calls should return different lists
        return itemDataSource.fetchAfter("next id").map { dto ->
            Item(
                id = ID(dto.id),
                url = dto.thumbnail,
                type = dto.type,
                title = dto.caption,
                description = dto.description
            )
        }
    }
}