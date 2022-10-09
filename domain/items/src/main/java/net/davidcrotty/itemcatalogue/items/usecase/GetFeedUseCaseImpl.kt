package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class GetFeedUseCaseImpl(private val itemRepository: ItemRepository) : GetFeedUsecase {
    override suspend fun getFeed(): ItemRepository.ItemListStatus {
        return itemRepository.getItems()
    }
}