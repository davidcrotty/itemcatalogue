package net.davidcrotty.itemcatalogue.data.item.dto.pure

data class ItemDTO(
    val id: String,
    val type: String,
    val subtype: String,
    val caption: String,
    val description: String,
    val thumbnail: String,
    val detailImage: String?,
    val damageType: String
)