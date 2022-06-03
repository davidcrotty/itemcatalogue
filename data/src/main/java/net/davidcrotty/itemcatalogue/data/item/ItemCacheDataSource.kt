package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID

interface ItemCacheDataSource {
    fun getLastID(): ID?
    fun setLastID(id: ID)
}