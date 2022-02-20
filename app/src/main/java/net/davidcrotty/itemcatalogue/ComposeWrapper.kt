package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

@Composable
fun ComposeWrapper(itemScreenGraph: ItemScreenGraph, navigate: (path: String) -> Unit) {
    CatalogueTemplateTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "item") {
            composable("itemList") {
                ItemListScreen(itemScreenGraph = itemScreenGraph, navigate = { navigate(it) })
            }
            composable("item") { ItemDetailScreen() }
        }
    }
}