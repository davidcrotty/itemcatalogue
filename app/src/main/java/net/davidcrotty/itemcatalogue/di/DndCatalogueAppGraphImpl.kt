package net.davidcrotty.itemcatalogue.di

import com.squareup.moshi.Moshi
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSourceImpl
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.model.Configuration
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import okhttp3.OkHttpClient

class DndCatalogueAppGraphImpl : DndCatalogueAppContainer {

    private val apiFactory: RemoteItemAPIFactory by lazy {
        RemoteItemAPIFactoryImpl(
            moshi = Moshi.Builder().build(),
            okHttp = OkHttpClient.Builder().build(),
            baseUrl = "https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/"
        )
    }

    private val configuration: Configuration by lazy { Configuration(pageLimit = 6) }

    private val itemsFetchedCache: ItemCacheDataSource by lazy {
        ItemCacheDataSourceImpl()
    }

    override fun itemScreenGraph(): ItemScreenGraph {
        return ItemScreenGraphImpl(
            ItemRepositoryImpl(
                RemoteItemDataSource(apiFactory.getInstance()),
                itemsFetchedCache,
                configuration
            )
        )
    }

    override fun mainActivityGraph(): MainActivityGraph {
        return MainActivityGraphImpl()
    }
}