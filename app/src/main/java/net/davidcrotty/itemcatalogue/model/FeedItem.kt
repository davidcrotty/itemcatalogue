package net.davidcrotty.itemcatalogue.model

import net.davidcrotty.itemcatalogue.items.entity.ID

data class FeedItem(
    val id: ID,
    val url: String,
    val type: String,
    val title: String,
    val description: String
)