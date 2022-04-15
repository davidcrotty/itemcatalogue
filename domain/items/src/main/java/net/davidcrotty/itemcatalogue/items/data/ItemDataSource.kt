package net.davidcrotty.itemcatalogue.items.data

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemDataSource {
    suspend fun fetchAfter(id: String): List<Item>
}