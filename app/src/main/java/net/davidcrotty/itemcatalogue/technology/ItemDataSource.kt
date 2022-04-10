package net.davidcrotty.itemcatalogue.technology

import net.davidcrotty.itemcatalogue.items.ID
import net.davidcrotty.itemcatalogue.items.Item

interface ItemDataSource {
    fun fetchAfter(id: ID): List<Item>
}