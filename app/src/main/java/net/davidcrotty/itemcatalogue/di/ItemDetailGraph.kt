package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel

interface ItemDetailGraph {
    fun itemDetailViewModel(): ItemDetailViewModel
}