package net.davidcrotty.itemcatalogue.items.repository

import net.davidcrotty.itemcatalogue.items.entity.ItemEntity

interface ItemRepository {
    fun getItems(): List<ItemEntity>
}