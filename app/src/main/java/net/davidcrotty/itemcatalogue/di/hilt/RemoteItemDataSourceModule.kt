package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteItemDataSourceModule {
    @Binds
    abstract fun bind(remoteItemDataSourceImpl: RemoteItemDataSourceImpl): RemoteItemDataSource
}