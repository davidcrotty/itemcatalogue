package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Query
import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemRepository {
    fun getItems(query: Query): List<Item>
}