package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.listscreen.model.ListTemplateState
import net.davidcrotty.itemcatalogue.listscreen.model.LoadingState
import net.davidcrotty.itemcatalogue.listscreen.presentation.ListTemplateViewModel
import net.davidcrotty.itemcatalogue.listscreen.ui.ItemListScreen
import net.davidcrotty.itemcatalogue.listscreen.ui.ItemListTemplate
import org.junit.Rule
import org.junit.Test

class ListTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_testing_initial_fetch() {
        var timesInvoked = 0
        val fetchMore = {
            timesInvoked++
            Unit
        }
        val initialFetch = true

        composeTestRule.setContent {
            ItemListTemplate(itemListState = ListTemplateState(emptyList(), LoadingState.CanLoadMore, initialFetch), {}, fetchMore)
        }

        assertEquals(1, timesInvoked)
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

        composeTestRule.setContent {
            ItemListScreen(
                viewModel
            )
        }

        composeTestRule.onNodeWithContentDescription("Item Feed Retry indicator").performClick()

        verify(exactly = 2) { viewModel.fetchItems() }
    }

}