package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.template.ListTemplate

@Composable
fun ItemListScreen(itemScreenGraph: ItemScreenGraph, navigate: ((path: String) -> Unit)? = null) {
    val itemsViewModel = itemScreenGraph.itemViewModel()
    val itemStateList by itemsViewModel.items.collectAsState()
    ListTemplate(itemStateList, navigate) {
        itemsViewModel.fetchItems()
    }
}