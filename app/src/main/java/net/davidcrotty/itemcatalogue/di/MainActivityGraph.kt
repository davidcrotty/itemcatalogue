package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel

interface MainActivityGraph {
    fun viewModel(): MainActivityViewModel
}