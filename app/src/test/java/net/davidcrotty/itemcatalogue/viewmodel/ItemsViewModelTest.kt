package net.davidcrotty.itemcatalogue.viewmodel

import fr.xgouchet.elmyr.Forge
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class ItemsViewModelTest {

    private val forge = Forge()

    @Test
    fun when_fetching_items() = runBlocking {
        // Given a valid item list
        val itemList = listOf(
            Item(
                id = ID(forge.anInt()),
                url = forge.aString(),
                type = forge.aString(),
                title = forge.aString(),
                description = forge.aString()
            )
        )
        val testDispatcher = TestCoroutineScheduler()
        val sut = ItemsViewModel(
            StandardTestDispatcher(testDispatcher),
            mockk {
                every { getItems() } returns itemList
            }
        )

        // When fetching items
        sut.fetchItems()
        testDispatcher.advanceUntilIdle()

        // Then should render item
        val state = sut.items.first()
        assertEquals(itemList, state)
    }
}