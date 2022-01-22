package net.davidcrotty.itemcatalogue.technology

import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID

interface ItemDataSource {
    fun fetchAfter(id: ID): List<Item>
}