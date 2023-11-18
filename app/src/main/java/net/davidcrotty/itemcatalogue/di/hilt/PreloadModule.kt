package net.davidcrotty.itemcatalogue.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCase
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class PreloadModule {

    @Binds
    abstract fun providePreloadUseCase(preloadUseCaseImpl: PreloadUseCaseImpl): PreloadUseCase

}