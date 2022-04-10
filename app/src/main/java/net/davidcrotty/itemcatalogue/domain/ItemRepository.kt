package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Query
import net.davidcrotty.itemcatalogue.items.Item

interface ItemRepository {
    fun getItems(query: Query): List<Item>
}