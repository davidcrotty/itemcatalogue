package net.davidcrotty.itemcatalogue.data.item

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import retrofit2.HttpException
import java.io.IOException

class RemoteItemDataSourceImpl(
    private val itemAPI: ItemAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteItemDataSource {

    // TODO figure out how to make multiple tokens with shorter expiry's
    private val apiToken =
        "eyJhbGciOiJSUzI1NiIsImtpZCI6IjcyOTE4OTQ1MGQ0OTAyODU3MDQyNTI2NmYwM2U3MzdmNDVhZjI5MzIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIzMjU1NTk0MDU1OS5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsImF1ZCI6IjMyNTU1OTQwNTU5LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTAxMjU2NTc5MjEwMTUyOTIxMjQ4IiwiZW1haWwiOiJkYXZpZGNyb3R0eXdvcmtAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiJELU55V1BuM2RTZmFQaEhYazZzb293IiwiaWF0IjoxNjQ3ODA3ODA0LCJleHAiOjE2NDc4MTE0MDR9.CPf-NVaEljIdTMF48bx2VB9K1uKVQnF-gUZpkylAxP58JNZK5DRbK6FW1GfAKZoMZVHtR4Xz48jkdq5gXXsM-WfqSTmiXBsKEGk84gkYWtwAG-3h-ObDmEq3L75FPHdloT0eoXqMAM57M9JvTmiDmWtSkJF6puNqFUEK8TITE8JTjkhxWZ_-JYiHsPi1FDZZT03zVlzqs-Gx1--o8OXww52Q7y8F5z5_75RDvV7qf6MKnq3q4Nyjc27qsSZv0Tfri5QZfgVz3QFnu6e-K1LsH8VuCZf7J3idvDpIc6FIlK-tFzR0lG0xythi7ImTEdkIxgdFgdjWZ09YC36KmzJE3A"

    // TODO make into object for queries
    override suspend fun fetchAfter(id: String?, limit: Int): List<ItemDTO> {
        val items = withContext(dispatcher) {
            try {
                // TODO log trace ids for logging
                itemAPI.getItems(apiToken, limit, id)
            } catch (e: HttpException) {
                val httpCode = e.code()
                if (httpCode == 404 || httpCode == 500) {
                    throw ContentNotFound()
                } else {
                    throw ContentFailedToFetch()
                }
            } catch (e: IOException) {
                throw ContentFailedToFetch()
            }
        }

        // Answer, only test the data adapter layer if needed - At the moment this isn't separated
        return items.map {
            ItemDTO(
                id = it.id,
                type = it.type,
                subtype = it.subtype,
                caption = it.caption,
                description = it.description,
                thumbnail = it.thumbnail,
                detailImage = it.detailImage
            )
        }
    }
}