package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val dndContainer by lazy { applicationContext.applicationContext as DndCatalogueAppContainer }

    private val viewModel = LaunchViewModel()

    class LaunchViewModel : ViewModel() {

        var dismissSplashScreen = true

        fun loadFeed() {
            viewModelScope.launch {
                delay(5000)
                dismissSplashScreen = false
            }
        }

    }

    @OptIn(ExperimentalAnimationGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { viewModel.dismissSplashScreen }
        viewModel.loadFeed()
        setContent {
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