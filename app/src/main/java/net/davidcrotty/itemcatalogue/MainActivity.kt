package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.organism.PreloadApplicationErrorDialog
import net.davidcrotty.itemcatalogue.technology.navigation.NavFactoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavigationHandler
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {

    private val dndContainer by lazy { applicationContext.applicationContext as DndCatalogueAppContainer }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        val viewModel = dndContainer.mainActivityGraph().viewModel()
        splashScreen.setKeepOnScreenCondition { viewModel.shouldKeepSplashOnScreen() }
        viewModel.preloadApplication()
        setContent {
            val showErrorDialog by viewModel.launchErrorDialogShown.collectAsState()
            CatalogueTemplateTheme {
                if (showErrorDialog) {
                    PreloadApplicationErrorDialog()
                } else {
                    val controller = rememberNavController()
                    NavigationHandler(
                        controller = controller,
                        itemScreenGraph = dndContainer.itemScreenGraph(),
                        navigator = dndContainer.navigator { controller }
                    )
                }
            }
        }
    }
}