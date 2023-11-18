package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSourceImpl
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ItemCacheDataSourceModule {

    @Binds
    abstract fun bind(itemCacheDataSource: ItemCacheDataSourceImpl): ItemCacheDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object ItemCacheModule {

    @Singleton
    @Provides
    fun provideMap(): MutableMap<ID, Item> {
        return mutableMapOf()
    }
}