package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.navigation.NavController

class NavigatorImpl(val navController: NavController) : Navigator {
    override fun navigate(path: String) {
        navController.navigate(path)
    }
}