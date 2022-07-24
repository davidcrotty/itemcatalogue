package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCaseImpl
import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel

class MainActivityGraphImpl : MainActivityGraph {

    private val viewModel by lazy { MainActivityViewModel(PreloadUseCaseImpl()) }

    override fun viewModel(): MainActivityViewModel {
        return viewModel
    }
}