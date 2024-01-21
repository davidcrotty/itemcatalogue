package net.davidcrotty.itemcatalogue.technology.navigation

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

@Composable
fun NavigationGraph(
    controller: NavHostController,
    itemListScreenFactory: @Composable () -> Unit,
    titleChange: (String) -> Unit,
    overlayChange: (Boolean) -> Unit
) {
    NavHost(navController = controller, startDestination = "itemList") {
        composable("itemList") {
            titleChange(stringResource(id = R.string.listing_title))
            overlayChange(false)
            itemListScreenFactory()
        }
        composable("item/{itemId}", arguments = listOf(navArgument("itemId") {
            type = NavType.StringType
            nullable = false
        })) { _ ->
            titleChange("")
            overlayChange(true)
            ItemDetailScreen(
                detailViewModel = hiltViewModel() as ItemDetailViewModel
            )
        }
    }
}