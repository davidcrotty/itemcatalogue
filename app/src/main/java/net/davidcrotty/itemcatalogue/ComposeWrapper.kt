package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.ItemListScreen

@Composable
fun ComposeWrapper(
    navController: NavHostController,
    itemScreenGraph: ItemScreenGraph,
    navigate: (path: String) -> Unit,
    container: DndCatalogueAppContainer
) {
    NavHost(navController = navController, startDestination = "itemList") {
        composable("itemList") {
            ItemListScreen(itemScreenGraph = itemScreenGraph, navigate = { navigate(it) })
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
                detailViewModel = container.itemDetailGraph().itemDetailViewModel { status }
            )
        }
    }
}