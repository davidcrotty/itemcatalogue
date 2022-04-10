package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class ItemListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Ignore("Come back to this once we have a real feed, should try the theory of a navigator per list item that can be injected to make this a unit test of behaviour")
    @Test
    fun when_navigating_to_item_detail() {
        // given a rendered item
        val itemViewModel = mockk<ItemsViewModel>(relaxed = true) {
            every { items } returns flow {
                emit(
                    listOf(
                        Item(
                            id = ID(0),
                            url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                            type = "Type",
                            title = "Title",
                            description = "test description"
                        )
                    )
                )
            }
        }
        val itemGraph = mockk<ItemScreenGraph>(relaxed = true) {
            every { itemViewModel() } returns itemViewModel
        }
        val navigate = mockk<((path: String) -> Unit)>(relaxed = true)

        composeTestRule.setContent {
            // TODO scope to a single item and verify interaction with navigator interface
        }

        // when interacting with item
        composeTestRule.onNodeWithContentDescription("List item").performClick()

        // then should navigate to detail screen with id
//        verify { navigate.invoke("item") }
    }
}