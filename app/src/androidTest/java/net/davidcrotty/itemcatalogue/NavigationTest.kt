package net.davidcrotty.itemcatalogue

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.technology.navigation.NavFactoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationGraph
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_when_navigating_invalid_path() {
        val path = "invalid"
        composeTestRule.setContent {
            val navController = rememberNavController()
            val navFactory = NavFactoryImpl { navController }
            val sut = NavigatorImpl(navFactory)
            val itemViewModel = mockk<ListTemplateViewModel> {
                every { listState } returns MutableStateFlow(
                    ListTemplateState(
                        emptyList(),
                        LoadingState.Retry
                    )
                )
            }
            val itemScreenGraph = mockk<ItemScreenGraph> {
                every { itemViewModel() } returns itemViewModel
            }
            NavigationGraph(
                controller = navController,
                appContainer = mockk(),
                itemListScreenFactory =  { ItemListScreen(itemViewModel) { sut.navigate(it) } }
            )

            val result = sut.navigate(path)

            assertEquals(Navigator.NavigationResult.Failure, result)
        }
    }

    @Test
    fun test_when_navigating_valid_path() {
        val path = "itemList"

        composeTestRule.setContent {
            val navController = rememberNavController()
            val navFactory = NavFactoryImpl { navController }
            val sut = NavigatorImpl(navFactory)
            val itemViewModel = mockk<ListTemplateViewModel> {
                every { listState } returns MutableStateFlow(ListTemplateState(emptyList(), LoadingState.Retry))
            }

            NavigationGraph(controller = navController, appContainer = mockk(), itemListScreenFactory = { ItemListScreen(itemViewModel) { sut.navigate(it) } })

            val result = sut.navigate(path)

            assertEquals(Navigator.NavigationResult.Success, result)
        }
    }

}