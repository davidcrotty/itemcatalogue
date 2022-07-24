package net.davidcrotty.itemcatalogue.model

sealed class ApplicationLoadState {
    object Loading : ApplicationLoadState()
    object Success : ApplicationLoadState()
    object Failed : ApplicationLoadState()
}