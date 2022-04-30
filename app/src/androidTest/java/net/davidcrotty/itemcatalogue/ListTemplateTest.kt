package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import net.davidcrotty.itemcatalogue.template.ListTemplate
import org.junit.Rule
import org.junit.Test

class ListTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_rendering_loading_icon() {
        composeTestRule.setContent {
            ListTemplate(itemList = emptyList(), isLoading = true)
        }

        composeTestRule.onRoot().printToLog("TAG")
        composeTestRule.onNodeWithContentDescription("loading").assertExists()
    }
}