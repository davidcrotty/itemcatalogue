package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.items.entity.ItemEntity
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.technology.ItemDataSource

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource) : ItemRepository {
    override fun getItems(): List<ItemEntity> {
        return itemDataSource.fetchAfter("next id")
    }
}