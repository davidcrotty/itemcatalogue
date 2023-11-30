package net.davidcrotty.itemcatalogue.data.item

import android.util.Log
import net.davidcrotty.itemcatalogue.data.item.di.MemCache
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import javax.inject.Inject

class ItemCacheDataSourceImpl @Inject constructor(@MemCache private val memoryCache: MutableMap<ID, Item>) : ItemCacheDataSource {

    private var lastFetchedID: ID? = null

    override fun getLastID(): ID? {
        return lastFetchedID
    }

    override fun setLastID(id: ID) {
        lastFetchedID = id
    }

    override fun storeItems(list: List<Item>) {
        for (item in list) {
            memoryCache[item.id] = item
        }
    }

    override fun fetchStoredItems(): List<Item> {
        return memoryCache.toList().map { it.second }
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