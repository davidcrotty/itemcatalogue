package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class GetFeedUseCaseImpl(private val itemRepository: ItemRepository) : GetFeedUsecase {
    override suspend fun getFeed(): ItemRepository.ItemStatus {
        return itemRepository.getItems()
    }
}