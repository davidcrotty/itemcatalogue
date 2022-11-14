package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecaseImpl
import net.davidcrotty.itemcatalogue.model.Configuration
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel

class ItemDetailGraphImpl(
    private val remoteItemDataSource: RemoteItemDataSource,
    private val cacheDataSource: ItemCacheDataSource,
    private val configuration: Configuration
) : ItemDetailGraph {
    override fun itemDetailViewModel(): ItemDetailViewModel {
        return ItemDetailViewModel(
            GetItemUsecaseImpl(
                ItemRepositoryImpl(
                    remoteItemDataSource,
                    cacheDataSource,
                    configuration
                )
            )
        )
    }
}