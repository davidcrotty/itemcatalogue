package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.di.ItemListGraphImpl
import net.davidcrotty.itemcatalogue.template.ListTemplate

@Composable
fun ItemListScreen() {
    val itemGraph = ItemListGraphImpl()
    val itemsViewModel = itemGraph.itemViewModel()
    ListTemplate(itemsViewModel)
}