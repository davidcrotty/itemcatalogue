package net.davidcrotty.itemcatalogue.domain

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import net.davidcrotty.itemcatalogue.data.item.exception.ServerError
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

        val sut = ItemRepositoryImpl(
            itemDataSource = mockk { coEvery { fetchAfter(any(), any()) } returns apiItems },
            indexCache = mockk(relaxed = true),
            config = mockk(relaxed = true)
        )

        // when fetching items
        var items: ItemRepository.ItemStatus?
        runBlocking {
            items = sut.getItems()
        }


        // Then should return items
        val expectedItems = ItemRepository.ItemStatus.Available(listOf(
            Item(
                id = ID("id"),
                url = thumbnail,
                type = type,
                title = caption,
                description = description
            )
        ))
        assertEquals(expectedItems, items)
    }

    @Test
    fun `when fetching items with previously fetched content`() {
        val thumbnail = forge.aString()
        val type = forge.aString()
        val caption = forge.aString()
        val description = forge.aString()
        val id = forge.aString()

        val apiItems = listOf(
            ItemDTO(
                id = id,
                type = type,
                subtype = forge.aString(),
                caption = caption,
                description = description,
                thumbnail = thumbnail,
                detailImage = forge.aString()
            )
        )

        val mockDataSource: ItemDataSource = mockk {
            coEvery { fetchAfter("next id", any()) } returns apiItems
        }
        val indexCache: ItemCacheDataSource = mockk {
            every { getLastID() } returns ID("next id")
        }
        val sut = ItemRepositoryImpl(
            mockDataSource,
            indexCache,
            mockk(relaxed = true)
        )

        val items = runBlocking {
            sut.getItems()
        }

        val expectedItems = ItemRepository.ItemStatus.Available(listOf(
            Item(
                id = ID(id),
                url = thumbnail,
                type = type,
                title = caption,
                description = description
            )
        ))
        assertEquals(expectedItems, items)
    }

    @Test
    fun `when items cannot be found`() {
        val api: ItemDataSource = mockk { coEvery { fetchAfter(any(), any()) } throws ContentNotFound() }
        val sut = ItemRepositoryImpl(
            itemDataSource = api,
            indexCache = mockk(relaxed = true),
            config = mockk(relaxed = true)
        )

        val itemResult = runBlocking {
            sut.getItems()
        }

        // Then status should raise Unavailable with ItemsNotFound exception
        assertEquals(ItemRepository.ItemStatus.Unavailable, itemResult)
    }

    @Test
    fun `when server errors`() {
        val api: ItemDataSource = mockk { coEvery { fetchAfter(any(), any()) } throws ServerError() }
        val sut = ItemRepositoryImpl(
            itemDataSource = api,
            indexCache = mockk(relaxed = true),
            config = mockk(relaxed = true)
        )

        val itemResult = runBlocking {
            sut.getItems()
        }

        // Then status should raise Unavailable with ItemsNotFound exception
        assertEquals(ItemRepository.ItemStatus.Unavailable, itemResult)
    }

}