package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import io.mockk.*
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.template.ItemListTemplate
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel
import org.junit.Rule
import org.junit.Test

class ListTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_testing_initial_fetch() {
        val fetchMore = {}

        composeTestRule.setContent {
            ItemListTemplate(itemListState = ListTemplateState(emptyList(), LoadingState.CanLoadMore,), {}, fetchMore)
        }
    }

    @Test
    fun when_rendering_loading_icon_visible() {
        composeTestRule.setContent {
            ItemListTemplate(itemListState = ListTemplateState(emptyList(), LoadingState.CanLoadMore)) {}
        }

        composeTestRule.onNodeWithContentDescription("Item Feed Loading indicator").assertExists()
    }

    @Test
    fun when_rendering_retry_button_visible() {
        composeTestRule.setContent {
            ItemListTemplate(itemListState = ListTemplateState(emptyList(), LoadingState.Retry)) {}
        }

        composeTestRule.onNodeWithContentDescription("Item Feed Retry indicator").assertExists()
    }

    @Test
    fun when_retrying_feed_fetch() {
        val viewModel: ListTemplateViewModel = mockk {
            every { listState } returns MutableStateFlow(
                ListTemplateState(
                    emptyList(),
                    LoadingState.Retry
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

        composeTestRule.onNodeWithContentDescription("Item Feed Retry indicator").performClick()

        verify(exactly = 2) { viewModel.fetchItems() }
    }

}