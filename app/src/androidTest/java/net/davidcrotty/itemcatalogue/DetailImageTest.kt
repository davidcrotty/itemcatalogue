package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class DetailImageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_rendering_detail_image() {
        composeTestRule.setContent {

        }

        composeTestRule.onNodeWithContentDescription("Detail image").assertIsDisplayed()
    }
}