package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.platform.app.InstrumentationRegistry
import net.davidcrotty.itemcatalogue.organism.ItemCatalogueAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDisplaysTitle() {
        // Given a title name of listings
        val title = "Listings"

        // When rendering app bar
        composeTestRule.setContent {
            ItemCatalogueAppBar(title, {})
        }

        // Then should have correct title passed
        composeTestRule.onNodeWithContentDescription("Screen title").assertTextEquals(title)
    }

    @Test
    fun testDisplaysDefaultAppName() {
        // Given the app name
        val appName = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.app_name)

        // When rendering the app bar
        composeTestRule.setContent {
            ItemCatalogueAppBar { }
        }

        // Then should render the screen name
        composeTestRule.onNodeWithContentDescription("Screen title").assertTextEquals(appName)
    }
}