package net.davidcrotty.itemcatalogue.items.repository

import net.davidcrotty.itemcatalogue.items.entity.Item

interface ItemRepository {

    sealed class ItemStatus {
        data class Available(val items: List<Item>) : ItemStatus()
        object RecoverableError: ItemStatus()
        object UnrecoverableError : ItemStatus()
    }

    suspend fun getItems(): ItemStatus
}