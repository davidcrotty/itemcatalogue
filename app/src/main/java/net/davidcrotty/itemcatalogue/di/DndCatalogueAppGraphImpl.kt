package net.davidcrotty.itemcatalogue.di

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient

class DndCatalogueAppGraphImpl : DndCatalogueAppGraph {
    override fun remoteAPIFactory(): RemoteItemAPIFactory {
        return RemoteItemAPIFactoryImpl(
            moshi = Moshi.Builder().build(),
            okHttp = OkHttpClient.Builder().build(),
            baseUrl = "https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/"
        )
    }
}