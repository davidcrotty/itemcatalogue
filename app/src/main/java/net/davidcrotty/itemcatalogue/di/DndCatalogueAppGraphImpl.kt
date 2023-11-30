package net.davidcrotty.itemcatalogue.di

import androidx.navigation.NavController
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSourceImpl
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSourceImpl
import net.davidcrotty.itemcatalogue.di.hilt.CacheModule
import net.davidcrotty.itemcatalogue.model.PagingConfiguration
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavFactoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import okhttp3.OkHttpClient
import javax.inject.Inject

class DndCatalogueAppGraphImpl @Inject constructor(): DndCatalogueAppContainer {

    override fun navigator(navController: () -> NavController): Navigator {
        return NavigatorImpl(
            NavFactoryImpl(navController)
        )
    }
}