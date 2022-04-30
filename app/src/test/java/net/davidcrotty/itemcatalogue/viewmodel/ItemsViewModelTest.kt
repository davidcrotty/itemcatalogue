package net.davidcrotty.itemcatalogue.viewmodel

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.model.FeedItem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class ItemsViewModelTest : CoroutineTest {

    override var testScheduler = TestCoroutineScheduler()
    private val forge = Forge()

    @Test
    fun when_fetching_items() = runBlocking {
        // Given a valid item list
        val itemList = listOf(
            Item(
                id = ID(1),
                url = "url",
                type = "type",
                title = "title",
                description = "description"
            )
        )
        val sut = ListTemplateViewModel(
            mockk {
                coEvery { getItems() } returns itemList
            }
        )

        // When fetching items
        sut.fetchItems()
        testScheduler.advanceUntilIdle()

        // Then should render item
        val state = sut.items.first()
        val expected = listOf(
            FeedItem(
                url = "url",
                type = "type",
                title = "title",
                description = "description"
            )
        )
        assertEquals(expected, state)
    }
}