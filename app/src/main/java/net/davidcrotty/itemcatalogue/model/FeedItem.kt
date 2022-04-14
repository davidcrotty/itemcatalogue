package net.davidcrotty.itemcatalogue.model

import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.ItemEntity

data class FeedItem(
    override val id: ID,
    override val url: String,
    override val type: String,
    override val title: String,
    override val description: String
) : ItemEntity