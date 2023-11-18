package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraphImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class AppGraphModule {
    @Binds
    abstract fun bindGraph(dndCatalogueAppGraphImpl: DndCatalogueAppGraphImpl): DndCatalogueAppContainer
}