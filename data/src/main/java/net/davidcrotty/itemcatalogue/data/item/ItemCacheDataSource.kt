package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID

interface ItemCacheDataSource {
    fun lastID(): ID
}