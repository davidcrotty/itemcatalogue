package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.items.data.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource) : ItemRepository {
    override fun getItems(): List<Item> {
        return itemDataSource.fetchAfter("next id")
    }
}