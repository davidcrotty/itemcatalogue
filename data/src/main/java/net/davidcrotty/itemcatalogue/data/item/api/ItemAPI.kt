package net.davidcrotty.itemcatalogue.data.item.api

import net.davidcrotty.itemcatalogue.data.item.dto.technology.ItemMoshiDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ItemAPI {
    @GET("api/item")
    suspend fun getItems(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int
    ): List<ItemMoshiDTO>
}