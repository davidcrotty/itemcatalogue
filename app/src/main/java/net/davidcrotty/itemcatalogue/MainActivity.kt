package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.davidcrotty.itemcatalogue.organism.PreloadApplicationErrorDialog
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationGraph
import net.davidcrotty.itemcatalogue.theme.CatalogueTemplateTheme
import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel

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
                if (showErrorDialog) {
                    PreloadApplicationErrorDialog()
                } else {
                    val controller = rememberNavController()
                    NavigationGraph(
                        controller = controller,
                        itemListScreenFactory = {
                            ItemListScreen { controller.navigate(it) }
                        }
                    )
                }
            }
        }
    }
}