package net.davidcrotty.itemcatalogue.items.repository

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemRepository {
    suspend fun getItems(): List<Item>
}