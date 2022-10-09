package net.davidcrotty.itemcatalogue.items.usecase

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetItemDetailUsecaseTest {

    private val forge = Forge()

    @Test
    fun `when retrieving item detail`() {
        // Given a request for item detail
        val itemID = "624842bb3c93ea918aa9585c"
        val expectedItemDetail = ItemRepository.ItemStatus.Available(item(itemID))
        val sut = GetItemUsecaseImpl(
            mockk {
                coEvery { getItem(itemID) } returns expectedItemDetail
            }
        )

        // when fetching detail
        val itemDetail = runBlocking {
            sut.execute(itemID)
        }

        // then should provide item
        assertEquals(
            expectedItemDetail,
            itemDetail
        )
    }

    private fun item(id: String): Item {
        return Item(
            id = ID(id),
            url = forge.aString(),
            type = forge.aString(),
            title = forge.aString(),
            description = forge.aString()
        )
    }

    @Test
    fun `when retrieving item detail unavailable`() {

    }
}