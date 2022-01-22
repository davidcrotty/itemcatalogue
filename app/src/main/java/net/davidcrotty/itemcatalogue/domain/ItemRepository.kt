package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.Query

interface ItemRepository {
    fun getItems(query: Query): List<Item>
}