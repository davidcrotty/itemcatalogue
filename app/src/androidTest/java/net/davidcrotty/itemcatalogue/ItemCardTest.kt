package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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

    @Test
    fun when_clicking_item() {
        val onClick: () -> Unit = { }
        composeTestRule.setContent {
            ItemCard(
                onClick = onClick
            )
        }

        // print will provide semantics tree for matching for accessibility
        composeTestRule.onRoot().printToLog("ItemCardTest")

        composeTestRule.onNodeWithContentDescription("List item").performClick()
    }
}