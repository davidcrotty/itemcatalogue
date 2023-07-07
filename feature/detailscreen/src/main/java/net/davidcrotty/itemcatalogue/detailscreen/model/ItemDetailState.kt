package net.davidcrotty.itemcatalogue.detailscreen.model

data class ItemDetailState(
    val hasError: Boolean = true,
    val isLoading: Boolean = true,
    val itemDetail: ItemDetail = ItemDetail(image = ImageResult.Unavailable)
)