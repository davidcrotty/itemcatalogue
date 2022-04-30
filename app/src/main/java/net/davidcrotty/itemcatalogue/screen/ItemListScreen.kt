package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.template.ListTemplate

@Composable
fun ItemListScreen(itemScreenGraph: ItemScreenGraph, navigate: ((path: String) -> Unit)? = null) {
    val itemsViewModel = itemScreenGraph.itemViewModel()
    val itemStateList = itemsViewModel.items
    val isLoading by itemsViewModel.isLoading.collectAsState(true)
    ListTemplate(itemStateList, isLoading, navigate) {
        itemsViewModel.fetchItems()
    }
}