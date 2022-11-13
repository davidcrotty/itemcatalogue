package net.davidcrotty.itemcatalogue.technology.navigation

interface Navigator {
    fun navigate(path: String): NavigationResult

    sealed class NavigationResult {
        object Success : NavigationResult()
        object Failure : NavigationResult()
    }
}