package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        composable("item") { ItemDetailScreen(appGraph = container) }
    }
}