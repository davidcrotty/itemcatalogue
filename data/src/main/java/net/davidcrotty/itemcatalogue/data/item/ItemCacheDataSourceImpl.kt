package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

class ItemCacheDataSourceImpl(private val memoryCache: MutableMap<ID, Item>) : ItemCacheDataSource {

    private var lastFetchedID: ID? = null
    private var storedItems: List<Item> = emptyList()

    override fun getLastID(): ID? {
        return lastFetchedID
    }

    override fun setLastID(id: ID) {
        lastFetchedID = id
    }

    override fun storeItems(list: List<Item>) {
        storedItems += list
        for (item in list) {
            memoryCache[item.id] = item
        }
    }

    override fun fetchStoredItems(): List<Item> {
        return storedItems
    }

    override fun fetchItem(id: ID): ItemCacheDataSource.CacheResult {
        val result = memoryCache[id]
        return if (result == null) {
            ItemCacheDataSource.CacheResult.Miss
        } else {
            ItemCacheDataSource.CacheResult.Hit(result)
        }
    }
}