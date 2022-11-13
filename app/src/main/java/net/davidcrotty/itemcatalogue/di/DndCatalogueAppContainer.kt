package net.davidcrotty.itemcatalogue.di

import androidx.navigation.NavController
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator

interface DndCatalogueAppContainer {
    fun itemScreenGraph(): ItemScreenGraph
    fun mainActivityGraph(): MainActivityGraph
    fun navigator(navController: () -> NavController): Navigator
}