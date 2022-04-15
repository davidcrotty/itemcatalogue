package net.davidcrotty.itemcatalogue.data.item.dto.technology

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ItemMoshiDTO(
    @Json(name = "_id") val id: String,
    val type: String,
    val subtype: String,
    val caption: String,
    val description: String,
    val thumbnail: String,
    @Json(name = "detail_image") val detailImage: String
)