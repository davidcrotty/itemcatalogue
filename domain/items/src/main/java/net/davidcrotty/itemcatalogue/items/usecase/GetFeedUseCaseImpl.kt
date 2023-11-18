package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import javax.inject.Inject

class GetFeedUseCaseImpl @Inject constructor(private val itemRepository: ItemRepository) : GetFeedUsecase {
    override suspend fun getFeed(): ItemRepository.ItemListStatus {
        return itemRepository.getItems()
    }
}