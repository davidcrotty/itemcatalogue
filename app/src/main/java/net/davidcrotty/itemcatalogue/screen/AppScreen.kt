package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.MainActivity
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.listscreen.ui.ItemListScreen
import net.davidcrotty.itemcatalogue.organism.ItemCatalogueAppBar
import net.davidcrotty.itemcatalogue.screen.model.AppStateHolder
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationGraph
import net.davidcrotty.itemcatalogue.theme.LocalAppColours

@Composable
fun AppScreen() {
    var appState by remember { mutableStateOf(AppStateHolder("", false)) }
    val controller = rememberNavController()

    if (appState.isDetaiView) {
        Box {
            NavigationGraph(
                controller = controller,
                itemListScreenFactory = {
                    ItemListScreen { controller.navigate(it) }
                },
                { appState = it }
            )
            ItemCatalogueAppBar(title = appState.appTitle) {
                IconButton(onClick = { controller.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        }
    } else {
        Column {
            ItemCatalogueAppBar(title = appState.appTitle) {
                Box(
                    Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .border(
                            width = 1.dp, shape = CircleShape, brush = Brush.linearGradient(
                                colors = listOf(
                                    LocalAppColours.current.highlight,
                                    LocalAppColours.current.highlight
                                )
                            )
                        )
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.ic_sword),
                        contentDescription = LocalContext.current.getString(R.string.screen_icon)
                    )
                }
            }
            NavigationGraph(
                controller = controller,
                itemListScreenFactory = {
                    ItemListScreen { controller.navigate(it) }
                },
                { appState = it }
            )
        }
    }
}