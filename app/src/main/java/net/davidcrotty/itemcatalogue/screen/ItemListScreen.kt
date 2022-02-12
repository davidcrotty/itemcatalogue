package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.di.ItemListGraphImpl
import net.davidcrotty.itemcatalogue.template.ListTemplate

@Composable
fun ItemListScreen() {
    val itemGraph = ItemListGraphImpl()
    val itemsViewModel = itemGraph.itemViewModel()
    val itemStateList = itemsViewModel.items.collectAsState(initial = emptyList()).value
    ListTemplate(itemStateList) {
        itemsViewModel.fetchItems()
    }
}