package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecaseImpl
import net.davidcrotty.itemcatalogue.model.PagingConfiguration
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailContract
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailViewModel

class ItemDetailGraphImpl(
    private val remoteItemDataSource: RemoteItemDataSource,
    private val cacheDataSource: ItemCacheDataSource,
    private val pagingConfiguration: PagingConfiguration
) : ItemDetailGraph {
    override fun itemDetailViewModel(itemID: () -> ItemIDStatus): ItemDetailContract{
        return null!!
    }
}