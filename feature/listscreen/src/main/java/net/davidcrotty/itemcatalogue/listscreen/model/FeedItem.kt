package net.davidcrotty.itemcatalogue.listscreen.model

data class FeedItem(
    val id: String,
    val url: String,
    val type: String,
    val subType: String,
    val title: String,
    val description: String,
    val element: String
)