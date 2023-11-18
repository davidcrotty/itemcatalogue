package net.davidcrotty.itemcatalogue.di

import androidx.navigation.NavController
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSourceImpl
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSourceImpl
import net.davidcrotty.itemcatalogue.model.Configuration
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.technology.navigation.NavFactory
import net.davidcrotty.itemcatalogue.technology.navigation.NavFactoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import okhttp3.OkHttpClient
import javax.inject.Inject

class DndCatalogueAppGraphImpl @Inject constructor(): DndCatalogueAppContainer {

    private val apiFactory: RemoteItemAPIFactory by lazy {
        RemoteItemAPIFactoryImpl(
            moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build(),
            okHttp = OkHttpClient.Builder().build(),
            baseUrl = "https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/"
        )
    }

    private val configuration: Configuration by lazy { Configuration(pageLimit = 6) }

    private val itemsFetchedCache: ItemCacheDataSource by lazy {
        ItemCacheDataSourceImpl(mutableMapOf())
    }

    override fun itemListScreenGraph(): ItemScreenGraph {
        return ItemScreenGraphImpl(
            ItemRepositoryImpl(
                RemoteItemDataSourceImpl(apiFactory.getInstance()),
                itemsFetchedCache,
                configuration
            )
        )
    }

    override fun mainActivityGraph(): MainActivityGraph {
        return MainActivityGraphImpl(
            ItemRepositoryImpl(
                RemoteItemDataSourceImpl(apiFactory.getInstance()),
                itemsFetchedCache,
                configuration
            )
        )
    }

    override fun itemDetailGraph(): ItemDetailGraph {
        return ItemDetailGraphImpl(
            RemoteItemDataSourceImpl(apiFactory.getInstance()),
            itemsFetchedCache,
            configuration
        )
    }

    override fun navigator(navController: () -> NavController): Navigator {
        return NavigatorImpl(
            NavFactoryImpl(navController)
        )
    }
}