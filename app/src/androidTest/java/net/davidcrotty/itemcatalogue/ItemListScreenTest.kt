package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.*
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel
import org.junit.Rule
import org.junit.Test

class ItemListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_fetching_more_items() {
        val numberOfItems = 5
        val viewModel: ListTemplateViewModel = mockk {
            every { listState } returns MutableStateFlow(
                ListTemplateState(
                    generateFeedItemList(numberOfItems),
                    LoadingState.CanLoadMore
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

        composeTestRule.onNodeWithContentDescription("Dungeon item feed").performScrollToIndex(numberOfItems)

        verify(exactly = 1) { viewModel.fetchItems() }
    }

    private fun generateFeedItemList(number: Int): List<FeedItem> {
        val itemList = mutableListOf<FeedItem>()
        for (item in 0..number) {
            itemList.add(FeedItem("", "", "", "", ""))
        }
        return itemList
    }
}