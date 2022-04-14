package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.data.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.Item

class RemoteItemDataSource : ItemDataSource {
    override fun fetchAfter(id: String): List<Item> {
        TODO("Not yet implemented")
    }
}