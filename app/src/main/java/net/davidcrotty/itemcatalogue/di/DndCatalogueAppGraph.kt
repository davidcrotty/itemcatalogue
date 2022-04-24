package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.RemoteItemAPIFactory

interface DndCatalogueAppGraph {
    fun remoteAPIFactory(): RemoteItemAPIFactory
}