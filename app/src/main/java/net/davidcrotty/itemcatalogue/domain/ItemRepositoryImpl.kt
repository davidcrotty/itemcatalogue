package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Query
import net.davidcrotty.itemcatalogue.technology.ItemDataSource

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource) : ItemRepository {
    override fun getItems(query: Query) {
        itemDataSource.fetchAfter(query.lastID)
    }
}