package net.davidcrotty.itemcatalogue

import android.app.Application
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraphImpl
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.di.RemoteItemAPIFactory

class DndCatalogueApp : Application(), DndCatalogueAppContainer {

    private val graph: DndCatalogueAppContainer by lazy { DndCatalogueAppGraphImpl() }

    override fun onCreate() {
        super.onCreate()
    }


    override fun itemScreenGraph(): ItemScreenGraph {
        return graph.itemScreenGraph()
    }
}