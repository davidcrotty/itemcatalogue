package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.template.ListTemplate

@Composable
fun ItemListScreen(itemScreenGraph: ItemScreenGraph) {
    val itemsViewModel = itemScreenGraph.itemViewModel()
    val itemStateList = itemsViewModel.items.collectAsState(initial = emptyList()).value
    ListTemplate(itemStateList) {
        itemsViewModel.fetchItems()
    }
}