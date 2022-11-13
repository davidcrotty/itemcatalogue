package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.navigation.NavController

interface NavFactory {
    fun fetch() : NavController
}

class NavFactoryImpl(private val navController: () -> NavController) : NavFactory{
    override fun fetch(): NavController {
        return navController.invoke()
    }

}

class NavigatorImpl(private val navFactory: NavFactory) : Navigator {
    override fun navigate(path: String): Navigator.NavigationResult {
        try {
            val controller = navFactory.fetch()
            controller.navigate(path)
        } catch (e: IllegalArgumentException) {
            return Navigator.NavigationResult.Failure
        }

        return Navigator.NavigationResult.Success
    }
}