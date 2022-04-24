package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraph
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemFactory = applicationContext.applicationContext as DndCatalogueAppGraph

        setContent {
            val controller = rememberNavController()
            val navigator = NavigatorImpl(controller)
            ComposeWrapper(controller, ItemScreenGraphImpl(
                itemFactory.remoteAPIFactory().getInstance()
            )) {
                 navigator.navigate(it)
            }
        }
    }
}