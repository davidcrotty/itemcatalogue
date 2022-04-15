package net.davidcrotty.itemcatalogue.data.item.api

import net.davidcrotty.itemcatalogue.data.item.dto.technology.ItemMoshiDTO
import retrofit2.http.GET
import retrofit2.http.Header

interface ItemAPI {
    @GET("api/item")
    suspend fun getItems(
        @Header("Authorization") token: String
    ): List<ItemMoshiDTO>
}