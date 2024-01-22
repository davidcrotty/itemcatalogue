package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performScrollToIndex
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import org.junit.Rule
import org.junit.Test
import java.util.UUID

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

        composeTestRule.setContent {
            ItemListScreen(
                viewModel
            )
        }

        composeTestRule.onNodeWithContentDescription("Dungeon item feed").performScrollToIndex(numberOfItems)

        verify(exactly = 2) { viewModel.fetchItems() }
    }

    private fun generateFeedItemList(number: Int): List<FeedItem> {
        val itemList = mutableListOf<FeedItem>()
        for (item in 0..number) {
            itemList.add(FeedItem(UUID.randomUUID().toString(), "", "", "", "", "", ""))
        }
        return itemList
    }
}