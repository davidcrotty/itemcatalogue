package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID

class ItemCacheDataSourceImpl : ItemCacheDataSource {
    override fun lastID(): ID {
        return ID("last id")
    }
}