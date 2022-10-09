package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemCacheDataSource {

    sealed class CacheResult {
        data class Hit(val item: Item) : CacheResult()
    }

    fun getLastID(): ID?
    fun setLastID(id: ID)
    fun storeItems(list: List<Item>)
    fun fetchStoredItems(): List<Item>
    fun fetchItem(id: ID): CacheResult
}