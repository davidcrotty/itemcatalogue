package net.davidcrotty.itemcatalogue

import android.app.Application
import net.davidcrotty.itemcatalogue.di.*

class DndCatalogueApp : Application(), DndCatalogueAppContainer {

    private val graph: DndCatalogueAppContainer by lazy { DndCatalogueAppGraphImpl() }

    override fun onCreate() {
        super.onCreate()
    }


    override fun itemScreenGraph(): ItemScreenGraph {
        return graph.itemScreenGraph()
    }

    override fun mainActivityGraph(): MainActivityGraph {
        return graph.mainActivityGraph()
    }
}