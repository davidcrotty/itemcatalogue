package net.davidcrotty.itemcatalogue.data.item

import fr.xgouchet.elmyr.Forge
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemCacheDataSourceImplTest {

    private val forge = Forge()

    @Test
    fun `storing items`() {
        // given a list of items
        val itemA = Item(
            id = ID("itemA"),
            url = forge.aString(),
            type = forge.aString(),
            title = forge.aString(),
            description = forge.aString()
        )

        val itemB = Item(
            id = ID("itemB"),
            url = forge.aString(),
            type = forge.aString(),
            title = forge.aString(),
            description = forge.aString()
        )
        val sut = ItemCacheDataSourceImpl(mutableMapOf())

        // when storing items
        sut.storeItems(listOf(itemA))
        sut.storeItems(listOf(itemB))

        // Then should be able to retrieve same list of items
        val storedItems = sut.fetchStoredItems()
        assertEquals(listOf(itemA, itemB), storedItems)
    }

    @Test
    fun `when fetching cached item`() {
        // Given has a memory cache store
        val id = ID(itemID())
        val item = item(itemID())
        val expected = ItemCacheDataSource.CacheResult.Hit(item)
        val sut = ItemCacheDataSourceImpl(mutableMapOf<ID, Item>())

        // When storing an item
        sut.storeItems(listOf(item))
        // When fetching cached item by id
        val result = sut.fetchItem(ID(itemID()))

        // Then item should be returned
        assertEquals(expected, result)
    }

    private fun itemID(): String {
        return "624842bb3c93ea918aa9585c"
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
}