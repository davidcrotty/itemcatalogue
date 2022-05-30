package net.davidcrotty.itemcatalogue.domain

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemRepositoryImplTest {

    private val forge = Forge()

    @Test
    fun `when retrieving items`() {
        // Given an available remote list of items
        val thumbnail = forge.aString()
        val type = forge.aString()
        val caption = forge.aString()
        val description = forge.aString()

        val apiItems = listOf(
            ItemDTO(
                id = "id",
                type = type,
                subtype = forge.aString(),
                caption = caption,
                description = description,
                thumbnail = thumbnail,
                detailImage = forge.aString()
            )
        )
        val expectedItems = ItemRepository.ItemStatus.Available(listOf(
            Item(
                id = ID("id"),
                url = thumbnail,
                type = type,
                title = caption,
                description = description
            )
        ))
        val sut = ItemRepositoryImpl(
            itemDataSource = mockk { coEvery { fetchAfter(any()) } returns apiItems },
            indexCache = mockk()
        )

        // when fetching items
        var items: ItemRepository.ItemStatus?
        runBlocking {
            items = sut.getItems()
        }


        // Then should return items
        assertEquals(expectedItems, items)
    }

    @Test
    fun `when failing to retrieve items`() {

    }
}