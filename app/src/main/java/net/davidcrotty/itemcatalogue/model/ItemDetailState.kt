package net.davidcrotty.itemcatalogue.model

data class ItemDetailState(
    val isLoading: Boolean = true,
    val itemDetail: ItemDetail? = ItemDetail()
)