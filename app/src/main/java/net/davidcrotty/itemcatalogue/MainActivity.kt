package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTemplateTheme {
                val controller = rememberNavController()
                val navigator: Navigator = NavigatorImpl(rememberNavController())

                // TODO does this work across multiple modules ?
                // TODO DRY up the nav pathing (Sealed class)
                NavHost(navController = controller, startDestination = "itemList") {
                    composable("itemList") {
                        ItemListScreen(itemScreenGraph = ItemScreenGraphImpl(), navigate = { navigator.navigate(it) })
                    }
                    composable("item") { ItemDetailScreen() }
                }
            }
        }
    }
}