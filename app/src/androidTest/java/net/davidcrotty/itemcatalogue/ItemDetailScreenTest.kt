package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemDetailGraph
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.model.ItemDetailState
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel
import org.junit.Rule
import org.junit.Test

class ItemDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_rendering_detail_image() {
        // given a url returned from vm
        val url = "https://i0.wp.com/www.chaoticanwriter.com/chaoticanwriter.com/wp-content/uploads/2022/03/flamge-tongue-magic-items.jpg"
        val viewModel = mockk<ItemDetailViewModel>() {
            every { renderItemDetail("") } just Runs
            every { itemDetailState } returns MutableStateFlow(
                ItemDetailState(
                    itemDetail = ItemDetail(
                        image = ImageResult.Image(url)
                    )
                )
            )
        }
        val detailGraph = mockk<ItemDetailGraph> {
            every { itemDetailViewModel() } returns viewModel
        }
        val containerMock = mockk<DndCatalogueAppContainer> {
            every { itemDetailGraph() } returns detailGraph
        }

        composeTestRule.setContent {
            ItemDetailScreen(appGraph = containerMock)
        }

        composeTestRule.onNodeWithContentDescription("Detail Image").assertIsDisplayed()
    }

}