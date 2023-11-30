package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import javax.inject.Inject

class GetItemUsecaseImpl @Inject constructor(private val itemRepository: ItemRepository) : GetItemUsecase {
    override suspend fun execute(itemID: String): ItemRepository.ItemStatus {
        return itemRepository.getItem(itemID)
    }
}