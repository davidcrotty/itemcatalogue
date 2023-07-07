package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailViewModel

interface ItemDetailGraph {
    fun itemDetailViewModel(itemID: () -> ItemIDStatus): ItemDetailViewModel
}