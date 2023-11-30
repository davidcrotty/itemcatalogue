package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.data.item.di.MemCache
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    private val itemCache by lazy {
        mutableMapOf<ID, Item>()
    }
    @MemCache
    @Provides
    fun provideCache(): MutableMap<ID, Item> {
        return itemCache
    }

}