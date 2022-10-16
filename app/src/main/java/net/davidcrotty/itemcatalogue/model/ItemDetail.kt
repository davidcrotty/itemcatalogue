package net.davidcrotty.itemcatalogue.model

data class ItemDetail(
    val title: String? = "",
    val type: String? = "",
    val description: String? = "",
    val image: String? = "" // TODO create image type to ensure 3rd parties can handle bad input
)