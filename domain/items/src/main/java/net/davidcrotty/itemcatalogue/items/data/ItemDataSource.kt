package net.davidcrotty.itemcatalogue.items.data

interface ItemDataSource {
    suspend fun fetchAfter(id: String): List<ItemDTO>
}