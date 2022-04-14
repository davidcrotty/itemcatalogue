package net.davidcrotty.itemcatalogue.domain

import fr.xgouchet.elmyr.Forge
import io.mockk.every
import io.mockk.mockk
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemRepositoryImplTest {

    private val forge = Forge()

    @Test
    fun `when retrieving items from remote server`() {

        // Given an available remote list of items
        val expectedItems = listOf(
            Item(
                id = ID(forge.anInt()),
                url = forge.aString(),
                type = forge.aString(),
                title = forge.aString(),
                description = forge.aString()
            )
        )
        val sut = ItemRepositoryImpl(
            mockk { every { fetchAfter(any()) } returns expectedItems }
        )

        // when fetching items
        val items = sut.getItems()

        // Then should return items
        assertEquals(expectedItems, items)
    }

    @Test
    fun `when failing to retrieve items from remote server`() {

    }
}