package net.davidcrotty.itemcatalogue.detailscreen.model

data class ItemDetail(
    val title: String? = "",
    val type: String? = "",
    val description: String? = "",
    val image: ImageResult,
    val element: String = ""
)