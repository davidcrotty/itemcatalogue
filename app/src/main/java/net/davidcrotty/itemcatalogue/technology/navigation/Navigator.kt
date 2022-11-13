package net.davidcrotty.itemcatalogue.technology.navigation

interface Navigator {
    fun navigate(path: String): NavigationResult
}