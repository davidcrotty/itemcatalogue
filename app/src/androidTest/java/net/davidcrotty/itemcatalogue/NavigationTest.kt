package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationHandler
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_when_navigating_invalid_path() {
        // Given an invalid path to navigate to
        val path = "invalid"

        composeTestRule.setContent {
            val navController = rememberNavController()
            val sut = NavigatorImpl(navController)
            val itemViewModel = mockk<ListTemplateViewModel> {
                every { listState } returns MutableStateFlow(ListTemplateState(emptyList(), LoadingState.Retry))
            }
            val itemScreenGraph = mockk<ItemScreenGraph> {
                every { itemViewModel() } returns itemViewModel
            }
            NavigationHandler(controller = navController, itemScreenGraph = itemScreenGraph, navigator = sut)

            // act:
            // invoke the nav
            sut.navigate(path)
        }

        // assert:
        // error page is displayed
    }

}