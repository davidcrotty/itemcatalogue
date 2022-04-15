package net.davidcrotty.itemcatalogue.data.item.api

import retrofit2.http.GET
import retrofit2.http.Header

interface ItemAPI {
    @GET("api/item")
    fun getItems(
        @Header("Authorization") token: String
    )
}