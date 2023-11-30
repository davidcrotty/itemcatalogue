package net.davidcrotty.itemcatalogue

import android.app.Application
import androidx.navigation.NavController
import dagger.hilt.android.HiltAndroidApp
import net.davidcrotty.itemcatalogue.di.*
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator

@HiltAndroidApp
class DndCatalogueApp : Application(), DndCatalogueAppContainer {

    private val graph: DndCatalogueAppContainer by lazy { DndCatalogueAppGraphImpl() }

    override fun navigator(navController: () -> NavController): Navigator {
        return graph.navigator(navController)
    }
}