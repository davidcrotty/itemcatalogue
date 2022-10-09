package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO

interface RemoteItemDataSource {
    suspend fun fetchAfter(id: String?, limit: Int): List<ItemDTO>
}