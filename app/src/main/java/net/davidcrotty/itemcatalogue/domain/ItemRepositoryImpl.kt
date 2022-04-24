package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource) : ItemRepository {
    override suspend fun getItems(): List<Item> {
        return itemDataSource.fetchAfter("next id").map { dto ->
            Item(
                id = ID(0), // TODO ID to become string
                url = dto.thumbnail,
                type = dto.type,
                title = dto.caption,
                description = dto.description
            )
        }
    }
}