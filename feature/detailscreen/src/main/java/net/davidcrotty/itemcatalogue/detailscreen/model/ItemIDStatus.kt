package net.davidcrotty.itemcatalogue.detailscreen.model

sealed class ItemIDStatus {
    data class Available(val value: String) : ItemIDStatus()
    object Unavailable : ItemIDStatus()
}