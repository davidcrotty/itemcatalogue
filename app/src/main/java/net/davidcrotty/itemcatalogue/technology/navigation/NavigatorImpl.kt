package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.navigation.NavController

class NavigatorImpl(private val navController: NavController) : Navigator {
    override fun navigate(path: String): Navigator.NavigationResult {
        // tech error would surface up to gateway which would tell it what to do on error
        try {
            navController.navigate(path)
        } catch (e: Exception) {
            return Navigator.NavigationResult.Failure
        }

        return Navigator.NavigationResult.Success
    }
}