package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import net.davidcrotty.itemcatalogue.detailscreen.ui.screen.ItemDetailScreen
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.organism.ItemCatalogueAppBar
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.theme.LocalAppColours
import net.davidcrotty.itemcatalogue.theme.LocalFont

@Composable
fun NavigationGraph(
    controller: NavHostController,
    itemScreenGraph: ItemScreenGraph,
    navigator: Navigator,
    appContainer: DndCatalogueAppContainer
) {
    Column {
        Surface {
            ItemCatalogueAppBar(title = stringResource(id = R.string.listing_title))
        }
        NavHost(navController = controller, startDestination = "itemList") {
            composable("itemList") {
                ItemListScreen(
                    itemScreenGraph = itemScreenGraph,
                    navigate = { navigator.navigate(it) })
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
}