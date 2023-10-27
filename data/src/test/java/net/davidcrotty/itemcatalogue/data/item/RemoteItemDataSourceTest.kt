package net.davidcrotty.itemcatalogue.data.item

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.dto.technology.ItemMoshiDTO
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import okhttp3.ResponseBody
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

internal class RemoteItemDataSourceTest {

    private val forger = Forge()

    // TODO GWT
    @Test
    fun `when a server error occurs`() {
        val previousItemID = "6518df37-524d-45f0-aa94-ba66e3cc9948"
        val itemLimit = 10

        val itemAPI = mockk<ItemAPI> {
            coEvery { getItems(any(), itemLimit, previousItemID) } throws HttpException(
                Response.error<List<ItemMoshiDTO>>(500, ResponseBody.create(null, ""))
            )
        }

        val sut = RemoteItemDataSourceImpl(
            itemAPI = itemAPI
        )

        runBlocking {
            assertThrows<ContentNotFound> {
                sut.fetchAfter(previousItemID, itemLimit)
            }
        }
    }

    @Test
    fun `when a network error occurs`() {
        val itemAPI: ItemAPI = mockk {
            coEvery { getItems(any(), any(), any()) } throws IOException()
        }
        val sut = RemoteItemDataSourceImpl(
            itemAPI = itemAPI
        )

        runBlocking {
            assertThrows<ContentFailedToFetch> {
                sut.fetchAfter(forger.aString(), forger.anInt())
            }
        }
    }
}