package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class GetItemUsecaseImpl(private val itemRepository: ItemRepository) : GetItemUsecase {
    override suspend fun execute(itemID: String): ItemRepository.ItemStatus {
        return itemRepository.getItem(itemID)
    }
}