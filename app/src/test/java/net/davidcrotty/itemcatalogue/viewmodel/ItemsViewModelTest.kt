package net.davidcrotty.itemcatalogue.viewmodel

import fr.xgouchet.elmyr.Forge
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemsViewModelTest : CoroutineTest {

    private val forge = Forge()
    override var testScope: TestCoroutineScope = TestCoroutineScope()
    override var dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Test
    fun when_fetching_items() = runBlockingTest {
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
        val sut = ItemsViewModel(
            mockk {
                every { getItems() } returns itemList
            }
        )

        // When fetching items
        val results = mutableListOf<List<Item>>()
        sut.fetchItems()
        val job = launch {
            sut.items.toList(results)
        }

        // Then should render item
        val state = results.firstOrNull()
        assertEquals(itemList, state)
        job.cancel()
    }
}