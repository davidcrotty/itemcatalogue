package net.davidcrotty.itemcatalogue.items.entity

data class Item(
    val id: ID,
    val url: String,
    val type: String,
    val subType: String,
    val title: String,
    val description: String,
    val element: String
)