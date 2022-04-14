package net.davidcrotty.itemcatalogue.items.entity

interface ItemEntity {
    val id: ID
    val url: String
    val type: String
    val title: String
    val description: String
}