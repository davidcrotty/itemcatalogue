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
                if(showErrorDialog) {
                    PreloadApplicationErrorDialog() // TODO does navigation allow emission of error dialogues? if so can go in compose wrapper
                } else {
                    val controller = rememberNavController()
                    val navigator = NavigatorImpl(controller)
                    ComposeWrapper(
                        controller, dndContainer.itemScreenGraph()
                    ) {
                        // Navigation handler, gets injected, factory pattern to receive nav controller
                        // write this as failing test first, expect error page
                        navigator.navigate(it)
                    }
                }
            }
        }
    }
}