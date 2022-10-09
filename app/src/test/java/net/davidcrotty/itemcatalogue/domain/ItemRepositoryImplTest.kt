package net.davidcrotty.itemcatalogue.domain

import fr.xgouchet.elmyr.Forge
import io.mockk.*
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.ItemCacheDataSource
import net.davidcrotty.itemcatalogue.data.item.ItemDataSource
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
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
        val expectedItems = listOf(
            Item(
                id = ID("id"),
                url = thumbnail,
                type = type,
                title = caption,
                description = description
            )
        )

        val itemCache: ItemCacheDataSource = mockk(relaxed = true) {
            every { setLastID(any()) } just Runs
            every { fetchStoredItems() } returns expectedItems
            every { storeItems(any()) } just Runs
        }

        val sut = ItemRepositoryImpl(
            itemDataSource = mockk { coEvery { fetchAfter(any(), any()) } returns apiItems },
            itemCache = itemCache,
            config = mockk(relaxed = true)
        )

        // when fetching items
        var items: ItemRepository.ItemListStatus?
        runBlocking {
            items = sut.getItems()
        }


        // Then should return items
        val expectedItemListStatus = ItemRepository.ItemListStatus.Available(expectedItems)
        assertEquals(expectedItemListStatus, items)
        verify { itemCache.setLastID(ID("id")) }
        verify { itemCache.storeItems(expectedItems) }
        verify { itemCache.fetchStoredItems() }
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

        val remoteItem = Item(
            id = ID(id),
            url = thumbnail,
            type = type,
            title = caption,
            description = description
        )

        val mockDataSource: ItemDataSource = mockk {
            coEvery { fetchAfter("next id", any()) } returns apiItems
        }
        val storedItem = Item(
            id = ID("id"),
            url = thumbnail,
            type = type,
            title = caption,
            description = description
        )
        val storedItemList = listOf(
            storedItem,
            remoteItem
        )
        val indexCache: ItemCacheDataSource = mockk {
            every { getLastID() } returns ID("next id")
            every { setLastID(any()) } just Runs
            every { storeItems(any()) } just Runs
            every { fetchStoredItems() } returns storedItemList
        }
        val sut = ItemRepositoryImpl(
            mockDataSource,
            indexCache,
            mockk(relaxed = true)
        )

        val items = runBlocking {
            sut.getItems()
        }

        val expectedItems = listOf(
            storedItem,
            remoteItem
        )
        val expectedStatus = ItemRepository.ItemListStatus.Available(expectedItems)
        assertEquals(expectedStatus, items)
        verify { indexCache.setLastID(ID(id)) }
        verify { indexCache.storeItems(listOf(remoteItem)) }
    }

    @Test
    fun `when items cannot be found`() {
        val api: ItemDataSource = mockk { coEvery { fetchAfter(any(), any()) } throws ContentNotFound() }
        val sut = ItemRepositoryImpl(
            itemDataSource = api,
            itemCache = mockk(relaxed = true),
            config = mockk(relaxed = true)
        )

        val itemResult = runBlocking {
            sut.getItems()
        }

        // Then status should raise Unavailable with ItemsNotFound exception
        assertEquals(ItemRepository.ItemListStatus.UnrecoverableError, itemResult)
    }

    @Test
    fun `when content is unavailable`() {
        val api: ItemDataSource = mockk { coEvery { fetchAfter(any(), any()) } throws ContentFailedToFetch() }
        val sut = ItemRepositoryImpl(
            itemDataSource = api,
            itemCache = mockk(relaxed = true),
            config = mockk(relaxed = true)
        )

        val itemResult = runBlocking {
            sut.getItems()
        }

        // Then status should raise Unavailable with ItemsNotFound exception
        assertEquals(ItemRepository.ItemListStatus.RecoverableError, itemResult)
    }

}