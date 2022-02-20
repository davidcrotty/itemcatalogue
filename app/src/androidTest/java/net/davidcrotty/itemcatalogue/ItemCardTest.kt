package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
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
    fun when_tapping_item() {
        val onClick = mockk<(() -> Unit)>(relaxed = true)
        composeTestRule.setContent {
            ItemCard(
                onClick = onClick
            )
        }

        composeTestRule.onNodeWithContentDescription("List item").performClick()

        verify { onClick.invoke() }
    }

}