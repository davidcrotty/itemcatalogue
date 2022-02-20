package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel
import org.junit.Rule
import org.junit.Test

class ItemListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_navigating_to_item_detail() {
        // given a rendered item
        val itemViewModel = mockk<ItemsViewModel>(relaxed = true) {
            every { items } returns flow { listOf(Item(
                id = ID(0),
                url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                type = "Type",
                title = "Title",
                description = "test description"
            )) }
        }
        val itemGraph = mockk<ItemScreenGraph>(relaxed = true) {
            every { itemViewModel() } returns itemViewModel
        }

        composeTestRule.setContent {
            ItemListScreen(itemGraph)
        }

        // when interacting with item
        composeTestRule.onRoot().printToLog("ItemListScreenTest")
        composeTestRule.onNodeWithContentDescription("Item list").onChildAt(0)

        // then should navigate to detail screen with id
    }
}