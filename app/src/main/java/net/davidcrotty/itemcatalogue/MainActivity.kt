package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.davidcrotty.itemcatalogue.organism.ItemCatalogueAppBar
import net.davidcrotty.itemcatalogue.organism.PreloadApplicationErrorDialog
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationGraph
import net.davidcrotty.itemcatalogue.theme.CatalogueTemplateTheme
import net.davidcrotty.itemcatalogue.theme.LocalCatalogTemplateValues
import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.theme.LocalAppColours

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { viewModel.shouldKeepSplashOnScreen() }
        viewModel.preloadApplication()
        setContent {
            val showErrorDialog by viewModel.launchErrorDialogShown.collectAsState()
            CatalogueTemplateTheme {
                Box(
                    Modifier
                        .background(LocalCatalogTemplateValues.current.backgroundToken.color)
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    if (showErrorDialog) {
                        PreloadApplicationErrorDialog()
                    } else {
                        AppTemplate()
                    }
                }
            }
        }
    }

    data class AppStateHolder(
        var appTitle: String,
        var appBarOverlayContent: Boolean
    )

    @Composable
    fun AppTemplate() {
        var appState by remember { mutableStateOf(AppStateHolder("", false)) }
        val controller = rememberNavController()

        if (appState.appBarOverlayContent) {
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
}