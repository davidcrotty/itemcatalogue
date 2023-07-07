package net.davidcrotty.itemcatalogue.detailscreen.model

sealed class ImageResult {
    data class Image(val url: String): ImageResult()
    object Unavailable: ImageResult()
}