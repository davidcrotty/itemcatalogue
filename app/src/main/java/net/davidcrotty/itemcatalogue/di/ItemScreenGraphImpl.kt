package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUseCaseImpl
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel

class ItemScreenGraphImpl(private val itemRepository: ItemRepositoryImpl) : ItemScreenGraph {
    override fun itemViewModel(): ListTemplateViewModel {
        return ListTemplateViewModel(
            GetFeedUseCaseImpl(
                itemRepository
            )
        )
    }
}