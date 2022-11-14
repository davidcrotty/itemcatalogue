package net.davidcrotty.itemcatalogue.technology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import net.davidcrotty.itemcatalogue.ComposeWrapper
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph

@Composable
fun NavigationHandler(
    controller: NavHostController,
    itemScreenGraph: ItemScreenGraph,
    navigator: Navigator,
    appContainer: DndCatalogueAppContainer
) {
    ComposeWrapper(
        controller, itemScreenGraph,
        {
            navigator.navigate(it)
        },
        appContainer
    )
}