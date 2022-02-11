package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import net.davidcrotty.itemcatalogue.organism.ItemCard
import org.junit.Rule
import org.junit.Test

class ItemCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_displaying_item() {
        composeTestRule.setContent {
            ItemCard()
        }

        composeTestRule.onNodeWithText("Type").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
    }
}