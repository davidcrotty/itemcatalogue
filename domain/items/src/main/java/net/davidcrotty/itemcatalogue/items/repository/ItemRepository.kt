package net.davidcrotty.itemcatalogue.items.repository

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemRepository {
    fun getItems(): List<Item>
}