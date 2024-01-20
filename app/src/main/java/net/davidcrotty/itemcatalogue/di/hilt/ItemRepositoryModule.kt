package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.model.PagingConfiguration

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