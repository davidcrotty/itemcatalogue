package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

interface ItemScreenGraph {
    fun itemViewModel(): ItemsViewModel
}