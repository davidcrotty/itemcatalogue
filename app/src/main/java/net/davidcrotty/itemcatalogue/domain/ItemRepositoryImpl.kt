package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Cursor
import net.davidcrotty.itemcatalogue.technology.ItemDataSource

class ItemRepositoryImpl(private val itemDataSource: ItemDataSource) : ItemRepository {
    override fun fetch(cursor: Cursor) {
        itemDataSource
    }
}