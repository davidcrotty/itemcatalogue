package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Query

interface ItemRepository {
    fun get(cursor: Query)
}