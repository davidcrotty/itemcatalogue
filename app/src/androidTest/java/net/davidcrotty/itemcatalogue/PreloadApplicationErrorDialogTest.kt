package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import net.davidcrotty.itemcatalogue.organism.PreloadApplicationErrorDialog
import org.junit.Rule
import org.junit.Test

class PreloadApplicationErrorDialogTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_when_rendering_error_dialog_recoverable_error() {
        composeTestRule.setContent {
            PreloadApplicationErrorDialog()
        }

        composeTestRule.onNodeWithContentDescription("unable to launch application heading").assertExists()
        composeTestRule.onNodeWithContentDescription("connectivity error").assertExists()
    }
}