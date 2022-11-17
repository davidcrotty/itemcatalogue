package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

@Composable
fun ComposeWrapper(navController: NavHostController, itemScreenGraph: ItemScreenGraph, navigate: (path: String) -> Unit, container: DndCatalogueAppContainer) {
    NavHost(navController = navController, startDestination = "itemList") {
        composable("itemList") {
            ItemListScreen(itemScreenGraph = itemScreenGraph, navigate = { navigate(it) })
        }
        composable("item/{itemId}", arguments = listOf(navArgument("itemId") {
            type = NavType.StringType
            nullable = false
        })) { navBackStackEntry ->
            // TODO, avoid passing empty, not clear - we can be explicit on types. even better factory extract this into
            // a viewmodel so it can relay the unavailable information to the view via one path to reduce duplication
            ItemDetailScreen(appGraph = container, itemID = navBackStackEntry.arguments?.getString("itemId") ?: "")
        }
    }
}