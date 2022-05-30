package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

interface GetFeedUsecase {
    suspend fun getFeed(): ItemRepository.ItemStatus
}