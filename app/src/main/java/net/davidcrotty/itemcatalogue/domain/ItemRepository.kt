package net.davidcrotty.itemcatalogue.domain

import net.davidcrotty.itemcatalogue.domain.model.Cursor

interface ItemRepository {
    fun fetch(cursor: Cursor)
}