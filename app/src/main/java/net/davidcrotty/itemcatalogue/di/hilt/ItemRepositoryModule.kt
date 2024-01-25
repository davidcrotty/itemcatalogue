package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.data.item.model.PagingConfiguration
import net.davidcrotty.itemcatalogue.data.item.repository.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class ItemRepositoryModule {

    @Binds
    abstract fun bind(itemRepositoryImpl: ItemRepositoryImpl): ItemRepository

}

@Module
@InstallIn(SingletonComponent::class)
object PagingConfiguration {
    @Provides
    fun provideConfiguration() = PagingConfiguration(pageLimit = 20)
}