package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUseCaseImpl
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel

class ItemScreenGraphImpl(private val itemRepository: ItemRepositoryImpl) : ItemScreenGraph {

    // when do you want a new viewmodel?
    private val viewModel: ListTemplateViewModel by lazy {
        ListTemplateViewModel(
            GetFeedUseCaseImpl(
                itemRepository
            )
        )
    }

    override fun itemViewModel(): ListTemplateViewModel {
        return viewModel
    }
}