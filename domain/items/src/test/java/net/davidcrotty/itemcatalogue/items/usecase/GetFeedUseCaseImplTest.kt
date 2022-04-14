package net.davidcrotty.itemcatalogue.items.usecase

import fr.xgouchet.elmyr.Forge
import io.mockk.every
import io.mockk.mockk
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
                every { getItems() } returns expectedItems
            }
        )

        // when fetching an item feed
        val items = sut.getFeed()

        // Then feed should be delivered
        assertEquals(expectedItems, items)
    }
}