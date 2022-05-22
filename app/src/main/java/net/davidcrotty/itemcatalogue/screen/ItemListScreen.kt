package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.template.ItemListTemplate

@Composable
fun ItemListScreen(itemScreenGraph: ItemScreenGraph, navigate: ((path: String) -> Unit)? = null) {
    val itemsViewModel = itemScreenGraph.itemViewModel()
    val itemStateList = itemsViewModel.items.collectAsState()
    ItemListTemplate(itemStateList.value, navigate) {
        itemsViewModel.fetchItems()
    }
}