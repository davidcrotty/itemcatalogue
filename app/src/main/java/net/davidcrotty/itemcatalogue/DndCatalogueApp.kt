package net.davidcrotty.itemcatalogue

import android.app.Application
import androidx.navigation.NavController
import net.davidcrotty.itemcatalogue.di.*
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator

class DndCatalogueApp : Application(), DndCatalogueAppContainer {

    private val graph: DndCatalogueAppContainer by lazy { DndCatalogueAppGraphImpl() }

    override fun onCreate() {
        super.onCreate()
    }


    override fun itemListScreenGraph(): ItemScreenGraph {
        return graph.itemListScreenGraph()
    }

    override fun mainActivityGraph(): MainActivityGraph {
        return graph.mainActivityGraph()
    }

    override fun itemDetailGraph(): ItemDetailGraph {
        return graph.itemDetailGraph()
    }

    override fun navigator(navController: () -> NavController): Navigator {
        return graph.navigator(navController)
    }
}