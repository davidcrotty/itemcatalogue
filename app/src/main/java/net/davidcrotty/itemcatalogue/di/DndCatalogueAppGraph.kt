package net.davidcrotty.itemcatalogue.di

interface DndCatalogueAppGraph {
    fun remoteAPIFactory(): RemoteItemAPIFactory
}