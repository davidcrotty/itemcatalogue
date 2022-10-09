package net.davidcrotty.itemcatalogue.items.repository

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemRepository {

    sealed class ItemStatus {
        data class Available(val item: Item) : ItemStatus()
        object Unavailable : ItemStatus()
    }

    sealed class ItemListStatus {
        data class Available(val items: List<Item>) : ItemListStatus()
        object RecoverableError: ItemListStatus()
        object UnrecoverableError : ItemListStatus()
    }

    suspend fun getItems(): ItemListStatus

    suspend fun getItem(id: String): ItemStatus
}