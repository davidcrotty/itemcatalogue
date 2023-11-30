package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUseCaseImpl
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUsecase

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedModule {
    @Binds
    abstract fun bind(getFeedUseCaseImpl: GetFeedUseCaseImpl): GetFeedUsecase
}