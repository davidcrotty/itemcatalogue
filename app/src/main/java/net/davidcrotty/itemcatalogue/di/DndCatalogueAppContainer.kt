package net.davidcrotty.itemcatalogue.di

import androidx.navigation.NavController
import net.davidcrotty.itemcatalogue.technology.navigation.Navigator

interface DndCatalogueAppContainer {
    fun itemListScreenGraph(): ItemScreenGraph
    fun mainActivityGraph(): MainActivityGraph
    fun itemDetailGraph(): ItemDetailGraph
    fun navigator(navController: () -> NavController): Navigator
}