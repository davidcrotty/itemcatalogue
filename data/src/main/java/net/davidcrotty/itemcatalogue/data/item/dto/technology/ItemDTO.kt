package net.davidcrotty.itemcatalogue.data.item.dto.technology

import com.squareup.moshi.Json

class ItemDTO(
    @Json(name = "_id") val id: String,
    val type: String,
    val subtype: String,
    val caption: String,
    val description: String,
    val thumbnail: String,
    @Json(name = "detail_image") val detailImage: String
)