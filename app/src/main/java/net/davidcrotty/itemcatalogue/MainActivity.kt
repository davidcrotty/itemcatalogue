package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {

    private val dndContainer by lazy { applicationContext.applicationContext as DndCatalogueAppContainer }

    @OptIn(ExperimentalAnimationGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        val viewModel = dndContainer.mainActivityGraph().viewModel()
        splashScreen.setKeepOnScreenCondition { viewModel.shouldKeepSplashOnScreen() }
        viewModel.preloadApplication()
        setContent {
            val showErrorDialog by viewModel.launchErrorDialogShown.collectAsState()
            if(showErrorDialog) {
                CatalogueTemplateTheme {
                    AlertDialog(onDismissRequest = { /*TODO*/ },
                    title = {
                        Text(text = "Unable to launch application")
                    },
                    text = {
                        // TODO pass reasons network or unknown error
                        Text(text = "Please check network connectivity and try again")
                    },
                    buttons = {})
                }
            } else {
                val controller = rememberNavController()
                val navigator = NavigatorImpl(controller)
                ComposeWrapper(
                    controller, dndContainer.itemScreenGraph()
                ) {
                    navigator.navigate(it)
                }
            }
        }
    }
}