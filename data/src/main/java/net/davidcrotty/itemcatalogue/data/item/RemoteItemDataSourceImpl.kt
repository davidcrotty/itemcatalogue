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
import javax.inject.Inject

class RemoteItemDataSourceImpl @Inject constructor(
    private val itemAPI: ItemAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteItemDataSource {

    // TODO make into object for queries
    override suspend fun fetchAfter(id: String?, limit: Int): List<ItemDTO> {
        val items = withContext(dispatcher) {
            try {
                // TODO log trace ids for logging
                itemAPI.getItems(limit, id)
            } catch (e: HttpException) {
                val httpCode = e.code()
                if (httpCode == 404 || httpCode == 500) {
                    throw ContentNotFound()
                } else {
                    throw ContentFailedToFetch()
                }
            } catch (e: Exception) {
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
                detailImage = it.detailImage,
                damageType = it.damageType.orEmpty()
            )
        }
    }
}