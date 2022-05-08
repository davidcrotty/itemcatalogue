package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.data.item.RemoteItemDataSource
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.domain.ItemRepositoryImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl

class MainActivity : ComponentActivity() {

    private val dndContainer by lazy { applicationContext.applicationContext as DndCatalogueAppContainer }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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