package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID

class ItemCacheDataSourceImpl : ItemCacheDataSource {

    private var lastFetchedID: ID? = null

    override fun getLastID(): ID? {
        return lastFetchedID
    }

    override fun setLastID(id: ID) {
        lastFetchedID = id
    }
}