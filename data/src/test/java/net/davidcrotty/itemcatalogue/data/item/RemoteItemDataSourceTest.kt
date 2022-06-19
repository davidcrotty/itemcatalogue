package net.davidcrotty.itemcatalogue.data.item

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException

internal class RemoteItemDataSourceTest {

    private val forger = Forge()

    @Test
    fun `when a network error occurs`() {
        val itemAPI: ItemAPI = mockk {
            coEvery { getItems(any(), any(), any()) } throws IOException()
        }
        val sut = RemoteItemDataSource(
            itemAPI = itemAPI
        )

        runBlocking {
            assertThrows<ContentFailedToFetch> {
                sut.fetchAfter(forger.aString(), forger.anInt())
            }
        }
    }
}