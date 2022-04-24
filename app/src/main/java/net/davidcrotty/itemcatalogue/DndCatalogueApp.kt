package net.davidcrotty.itemcatalogue

import android.app.Application
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraph
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraphImpl
import net.davidcrotty.itemcatalogue.di.RemoteItemAPIFactory

class DndCatalogueApp : Application(), DndCatalogueAppGraph {

    private val graph: DndCatalogueAppGraph by lazy { DndCatalogueAppGraphImpl() }

    override fun onCreate() {
        super.onCreate()

    }

    override fun remoteAPIFactory(): RemoteItemAPIFactory {
        return graph.remoteAPIFactory()
    }
}