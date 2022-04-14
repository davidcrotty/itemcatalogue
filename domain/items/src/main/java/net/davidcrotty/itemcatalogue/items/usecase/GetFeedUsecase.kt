package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.entity.Item

interface GetFeedUsecase {
    fun getFeed(): List<Item>
}