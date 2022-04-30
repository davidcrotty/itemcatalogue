package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel

class ItemScreenGraphImpl(private val itemAPI: ItemAPI) : ItemScreenGraph {
    override fun itemViewModel(): ListTemplateViewModel {
        return ListTemplateViewModel(
            ItemRepositoryImpl(
                RemoteItemDataSource(itemAPI)
            )
        )
    }
}