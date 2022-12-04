package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import org.junit.Rule
import org.junit.Test

class DetailImageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_rendering_detail_image() {
        val imageResult = ImageResult.Image("https://i0.wp.com/www.chaoticanwriter.com/chaoticanwriter.com/wp-content/uploads/2022/03/flamge-tongue-magic-items.jpg")

        composeTestRule.setContent {
            DetailImage(image = imageResult)
        }

        composeTestRule.onNodeWithContentDescription("Detail Image").assertIsDisplayed()
    }

    @Test
    fun when_image_not_available() {
        val imageResult = ImageResult.Unavailable

        composeTestRule.setContent {
            DetailImage(image = imageResult)
        }

        composeTestRule.onNodeWithContentDescription("Detail Image Unavailable").assertIsDisplayed()
    }
}