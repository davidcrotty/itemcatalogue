package net.davidcrotty.itemcatalogue.model

data class ItemDetail(
    val title: String? = "",
    val type: String? = "",
    val description: String? = "",
    val image: ImageResult
)