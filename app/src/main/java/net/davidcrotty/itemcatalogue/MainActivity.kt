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
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.organism.PreloadApplicationErrorDialog
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationGraph
import net.davidcrotty.itemcatalogue.theme.CatalogueTemplateTheme
import net.davidcrotty.itemcatalogue.viewmodel.MainActivityViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dndContainer: DndCatalogueAppContainer

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
                        itemScreenGraph = dndContainer.itemListScreenGraph(),
                        navigator = dndContainer.navigator { controller },
                        appContainer = dndContainer
                    )
                }
            }
        }
    }
}