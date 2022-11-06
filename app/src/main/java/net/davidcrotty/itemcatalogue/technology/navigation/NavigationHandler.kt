package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import net.davidcrotty.itemcatalogue.ComposeWrapper
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph

@Composable
fun NavigationHandler(controller: NavHostController, itemScreenGraph: ItemScreenGraph, navigator: Navigator) {
    ComposeWrapper(
        controller, itemScreenGraph
    ) {
        // Navigation handler, gets injected, factory pattern to receive nav controller
        // write this as failing test first, expect error page
        navigator.navigate(it)
    }
}