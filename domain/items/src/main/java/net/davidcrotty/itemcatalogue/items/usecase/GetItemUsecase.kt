package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

interface GetItemUsecase {
    suspend fun execute(itemID: String): ItemRepository.ItemStatus
}