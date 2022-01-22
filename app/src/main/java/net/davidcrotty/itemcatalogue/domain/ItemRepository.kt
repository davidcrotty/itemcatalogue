package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Query

interface ItemRepository {
    fun getItems(query: Query)
}