package net.davidcrotty.itemcatalogue

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

@Composable
fun ComposeWrapper(controller: NavHostController, navigate: (path: String) -> Unit) {
    CatalogueTemplateTheme {
        // TODO does this work across multiple modules ?
        // TODO DRY up the nav pathing (Sealed class)
        NavHost(navController = controller, startDestination = "itemList") {
            composable("itemList") {
                ItemListScreen(itemScreenGraph = ItemScreenGraphImpl(), navigate = { navigate(it) })
            }
            composable("item") { ItemDetailScreen() }
        }
    }
}