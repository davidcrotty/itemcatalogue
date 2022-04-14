package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import org.junit.jupiter.api.Test

internal class ItemsViewModelTest : CoroutineTest {

    override var testScope: TestCoroutineScope = TestCoroutineScope()
    override var dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Test
    fun when_fetching_items() {
        // Given a valid item
        val sut = ItemsViewModel(
            mockk()
        )

        // When fetching items
        sut.fetchItems()

        // Then should render item
    }
}