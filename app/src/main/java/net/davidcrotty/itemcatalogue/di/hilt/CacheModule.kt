package net.davidcrotty.itemcatalogue.di.hilt

import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

object CacheModule {
    val itemCache = mutableMapOf<ID, Item>()
}