package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import io.mockk.mockk
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.template.ListTemplate
import org.junit.Rule
import org.junit.Test

class ItemListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_navigating_to_item_detail() {
        // given a rendered item
        composeTestRule.setContent {
            ItemListScreen()
        }

        // when interacting with item

        // then should navigate to detail screen with id
    }
}