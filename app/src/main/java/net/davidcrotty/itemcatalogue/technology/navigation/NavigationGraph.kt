package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.MainActivity
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailViewModel
import net.davidcrotty.itemcatalogue.detailscreen.ui.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.screen.model.AppStateHolder

@Composable
fun NavigationGraph(
    controller: NavHostController,
    itemListScreenFactory: @Composable () -> Unit,
    appStateChange: (AppStateHolder) -> Unit
) {
    NavHost(navController = controller, startDestination = "itemList") {
        composable("itemList") {
            appStateChange(
                AppStateHolder(
                    stringResource(id = R.string.app_name),
                    false
                )
            )

            itemListScreenFactory()
        }
        composable("item/{itemId}", arguments = listOf(navArgument("itemId") {
            type = NavType.StringType
            nullable = false
        })) { _ ->
            appStateChange(
                AppStateHolder(
                    "",
                    true
                )
            )
            ItemDetailScreen(
                detailViewModel = hiltViewModel() as ItemDetailViewModel
            )
        }
    }
}