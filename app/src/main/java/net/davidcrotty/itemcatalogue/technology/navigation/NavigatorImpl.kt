package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.navigation.NavController

class NavigatorImpl(private val navController: NavController) : Navigator {
    override fun navigate(path: String): Navigator.NavigationResult {
        try {
            navController.navigate(path)
        } catch (e: IllegalArgumentException) {
            return Navigator.NavigationResult.Failure
        }

        return Navigator.NavigationResult.Success
    }
}