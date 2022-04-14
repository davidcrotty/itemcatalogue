package net.davidcrotty.itemcatalogue.items.data

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemDataSource {
    fun fetchAfter(id: String): List<Item>
}