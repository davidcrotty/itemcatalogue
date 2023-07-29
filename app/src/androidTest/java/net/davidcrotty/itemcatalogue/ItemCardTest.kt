package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.mockk
import io.mockk.verify
import net.davidcrotty.itemcatalogue.molecule.ItemCost
import net.davidcrotty.itemcatalogue.organism.ItemCard
import org.junit.Rule
import org.junit.Test

class ItemCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // render cost with no amount (should be 0)

    @Test
    fun when_rendering_cost_with_no_amounts() {

    }

    @Test
    fun when_rendering_cost() {
        val gold = 1
        val silver = 20
        val copper = 50

        composeTestRule.setContent {
            ItemCost(
                gold = gold,
                silver = silver,
                copper = copper
            )
        }
        composeTestRule.onRoot().printToLog("ITEM_CARD_TEST")

        // Then should see cost rendered
        composeTestRule.onNodeWithContentDescription("Item cost").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("1 Gold").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("20 Silver").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("50 Copper").assertIsDisplayed()
    }

    @Test
    fun when_displaying_item() {
        composeTestRule.setContent {
            ItemCard()
        }

        composeTestRule.onNodeWithText("Type").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
    }

    @Test
    fun when_tapping_item() {
        val onClick = mockk<(() -> Unit)>(relaxed = true)
        composeTestRule.setContent {
            ItemCard(
                onClick = onClick
            )
        }

        composeTestRule.onRoot().printToLog("ItemCardTest")
        composeTestRule.onNodeWithContentDescription("List item").performClick()

        verify { onClick.invoke() }
    }

}