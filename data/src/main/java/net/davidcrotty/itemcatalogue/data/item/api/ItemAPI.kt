package net.davidcrotty.itemcatalogue.data.item.api

import net.davidcrotty.itemcatalogue.data.item.dto.technology.ItemMoshiDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ItemAPI {
    @GET("/item")
    suspend fun getItems(
        @Query("limit") limit: Int,
        @Query("lastid") lastId: String? = null
    ): List<ItemMoshiDTO>
}