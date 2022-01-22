package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.technology.ItemMemoryDataSource
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

class ItemListGraphImpl : ItemListGraph {
    override fun itemViewModel(): ItemsViewModel {
        return ItemsViewModel(
            ItemRepositoryImpl(
                ItemMemoryDataSource()
            )
        )
    }
}