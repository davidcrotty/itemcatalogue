package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecaseImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class DetailModule {
    @Binds
    abstract fun bind(getFeedUseCaseImpl: GetItemUsecaseImpl): GetItemUsecase
}