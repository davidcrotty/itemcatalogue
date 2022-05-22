package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import net.davidcrotty.itemcatalogue.template.ListTemplate
import org.junit.Rule
import org.junit.Test

class ListTemplateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_rendering_loading_icon_visible() {
        composeTestRule.setContent {
            ListTemplate(itemList = emptyList(), canLoadMore = true)
        }

        composeTestRule.onNodeWithContentDescription("Item Feed Loading indicator").assertExists()
    }

}