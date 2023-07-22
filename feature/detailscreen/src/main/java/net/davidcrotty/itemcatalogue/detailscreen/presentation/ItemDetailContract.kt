package net.davidcrotty.itemcatalogue.detailscreen.presentation

import kotlinx.coroutines.flow.StateFlow
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetailState

interface ItemDetailContract {
    fun renderItemDetail()
    val itemDetailState: StateFlow<ItemDetailState>
}