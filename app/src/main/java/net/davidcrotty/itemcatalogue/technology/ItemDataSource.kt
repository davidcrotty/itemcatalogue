package net.davidcrotty.itemcatalogue.technology

import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemDataSource {
    fun fetchAfter(id: String): List<Item>
}