package net.davidcrotty.itemcatalogue.model

sealed class ItemIDStatus {
    data class Available(val value: String) : ItemIDStatus()
    object Unavailable : ItemIDStatus()
}