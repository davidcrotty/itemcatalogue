package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.entity.Item

interface GetFeedUsecase {
    suspend fun getFeed(): List<Item>
}