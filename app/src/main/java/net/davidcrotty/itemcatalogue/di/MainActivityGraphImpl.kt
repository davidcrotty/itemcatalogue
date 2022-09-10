package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCaseImpl
import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel

class MainActivityGraphImpl(private val itemRepository: ItemRepository) : MainActivityGraph {

    private val viewModel by lazy { MainActivityViewModel(PreloadUseCaseImpl(itemRepository)) }

    override fun viewModel(): MainActivityViewModel {
        return viewModel
    }
}