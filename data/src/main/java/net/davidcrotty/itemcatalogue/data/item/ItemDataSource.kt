package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO

interface ItemDataSource {
    suspend fun fetchAfter(id: String, limit: Int): List<ItemDTO>
}