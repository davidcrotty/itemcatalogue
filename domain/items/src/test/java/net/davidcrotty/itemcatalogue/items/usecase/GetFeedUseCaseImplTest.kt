package net.davidcrotty.itemcatalogue.items.usecase

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GetFeedUseCaseImplTest {

    private val forge = Forge()

    @Test
    fun `when retrieving an item list`() {
        // Given a list of items
        val expectedItems = listOf(
            Item(
                id = ID(1),
                url = forge.aString(),
                type = forge.aString(),
                title = forge.aString(),
                description = forge.aString()
            )
        )

        val sut = GetFeedUseCaseImpl(
            mockk {
                coEvery { getItems() } returns expectedItems
            }
        )

        // when fetching an item feed
        var items: List<Item>?
        runBlocking {
            items = sut.getFeed()
        }

        // Then feed should be delivered
        assertEquals(expectedItems, items)
    }
}