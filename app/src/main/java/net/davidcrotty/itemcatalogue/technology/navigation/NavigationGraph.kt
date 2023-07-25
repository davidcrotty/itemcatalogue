package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.detailscreen.ui.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.screen.ItemListScreen

@Composable
fun NavigationGraph(
    controller: NavHostController,
    itemScreenGraph: ItemScreenGraph,
    navigator: Navigator,
    appContainer: DndCatalogueAppContainer
) {
    NavHost(navController = controller, startDestination = "itemList") {
        composable("itemList") {
            ItemListScreen(itemScreenGraph = itemScreenGraph, navigate = { navigator.navigate(it) })
        }
        composable("item/{itemId}", arguments = listOf(navArgument("itemId") {
            type = NavType.StringType
            nullable = false
        })) { navBackStackEntry ->
            val itemID = navBackStackEntry.arguments?.getString("itemId")
            val status = if (itemID == null) {
                ItemIDStatus.Unavailable
            } else {
                ItemIDStatus.Available(itemID)
            }
            ItemDetailScreen(
                detailViewModel = appContainer.itemDetailGraph().itemDetailViewModel { status }
            )
        }
    }
}