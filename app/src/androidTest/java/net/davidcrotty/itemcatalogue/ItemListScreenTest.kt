package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.*
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel
import org.junit.Rule
import org.junit.Test

class ItemListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_fetching_more_items() {
        val viewModel: ListTemplateViewModel = mockk {
            every { items } returns MutableStateFlow(
                listOf(
                    generateFeedItem(),
                    generateFeedItem(),
                    generateFeedItem(),
                    generateFeedItem(),
                    generateFeedItem()
                )
            )
            every { fetchItems() } just Runs
        }
        val itemGraph = mockk<ItemScreenGraph> {
            every { itemViewModel() } returns viewModel
        }

        composeTestRule.setContent {
            ItemListScreen(
                itemGraph
            )
        }

        verify(exactly = 1) { viewModel.fetchItems() }
    }

    private fun generateFeedItem(): FeedItem {
        return FeedItem("", "", "", "")
    }
}