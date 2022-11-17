package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel

interface ItemDetailGraph {
    fun itemDetailViewModel(itemID: () -> ItemIDStatus): ItemDetailViewModel
}