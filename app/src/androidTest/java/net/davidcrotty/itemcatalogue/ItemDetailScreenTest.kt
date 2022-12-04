package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.model.ItemDetailState
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel
import org.junit.Rule
import org.junit.Test

class ItemDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun when_rendering_title() {
        val title = "Fire Sword"

        val viewModel = mockViewModel()
        every { viewModel.itemDetailState } returns MutableStateFlow(
            ItemDetailState(
                itemDetail = ItemDetail(
                    image = ImageResult.Image(""),
                    title = title
                )
            )
        )
        
        composeTestRule.setContent {
            ItemDetailScreen(detailViewModel = viewModel)
        }
        composeTestRule.onNodeWithContentDescription("Item Title").assertIsDisplayed()
    }

    @Test
    fun when_rendering_title_unavailable() {
        val viewModel = mockViewModel()

        composeTestRule.setContent {
            ItemDetailScreen(detailViewModel = viewModel)
        }
        composeTestRule.onRoot().printToLog("ITEM_DETAIL_SCREEN")
        composeTestRule.onNodeWithContentDescription("Item Title").assertDoesNotExist()
    }

    private fun mockViewModel(): ItemDetailViewModel {
        val url = "https://i0.wp.com/www.chaoticanwriter.com/chaoticanwriter.com/wp-content/uploads/2022/03/flamge-tongue-magic-items.jpg"
        
        return mockk<ItemDetailViewModel>() {
            every { renderItemDetail() } just Runs
            every { itemDetailState } returns MutableStateFlow(
                ItemDetailState(
                    itemDetail = ItemDetail(
                        image = ImageResult.Image(url)
                    )
                )
            )
        }
    }
}