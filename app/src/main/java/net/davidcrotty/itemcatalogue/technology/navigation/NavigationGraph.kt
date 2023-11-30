package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailViewModel
import net.davidcrotty.itemcatalogue.detailscreen.ui.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.organism.ItemCatalogueAppBar

@Composable
fun NavigationGraph(
    controller: NavHostController,
    itemListScreenFactory: @Composable () -> Unit
) {
    Column {
        Surface {
            ItemCatalogueAppBar(title = stringResource(id = R.string.listing_title))
        }
        NavHost(navController = controller, startDestination = "itemList") {
            composable("itemList") {
                itemListScreenFactory()
            }
            composable("item/{itemId}", arguments = listOf(navArgument("itemId") {
                type = NavType.StringType
                nullable = false
            })) { _ ->
                ItemDetailScreen(
                    detailViewModel = hiltViewModel() as ItemDetailViewModel
                )
            }
        }
    }
}