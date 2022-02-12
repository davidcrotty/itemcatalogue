package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.technology.ItemMemoryDataSource
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

class ItemScreenGraphImpl : ItemScreenGraph {
    override fun itemViewModel(): ItemsViewModel {
        return ItemsViewModel(
            ItemRepositoryImpl(
                ItemMemoryDataSource()
            )
        )
    }
}