package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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

    class AppStateHolder(
        var appTitle: String,
        var appBarOverlayContent: Boolean
    )

    @Composable
    fun AppTemplate() {
        var appTitle by remember { mutableStateOf("") }

        if (false) {
            Box {
                val controller = rememberNavController()
                NavigationGraph(
                    controller = controller,
                    itemListScreenFactory = {
                        ItemListScreen { controller.navigate(it) }
                    },
                    { appTitle = it },
                    { false }
                )
                ItemCatalogueAppBar(title = appTitle)
            }
        } else {
            Column {
                ItemCatalogueAppBar(title = appTitle)
                val controller = rememberNavController()
                NavigationGraph(
                    controller = controller,
                    itemListScreenFactory = {
                        ItemListScreen { controller.navigate(it) }
                    },
                    { appTitle = it },
                    { false }
                )
            }
        }
    }
}

@Composable
fun rememberAppScreenState(
    appState: MainActivity.AppStateHolder
): MainActivity.AppStateHolder = remember {
    appState
}