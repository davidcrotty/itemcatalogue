package net.davidcrotty.itemcatalogue.items.model

sealed class PreloadStatus {
    object Error : PreloadStatus()
    object Loaded: PreloadStatus()
}