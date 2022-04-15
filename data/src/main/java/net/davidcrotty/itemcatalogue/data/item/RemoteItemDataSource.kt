package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.data.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.Item

class RemoteItemDataSource : ItemDataSource {
    override fun fetchAfter(id: String): List<Item> {
        TODO("Not yet implemented, do we write two layers of test here - remote and data parsing?")
        // Answer, only test the data adapter layer if needed - At the moment this isn't separated
    }
}