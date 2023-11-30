package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import net.davidcrotty.itemcatalogue.di.ItemScreenGraph
import net.davidcrotty.itemcatalogue.template.ItemListTemplate
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateContract
import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel

@Composable
fun ItemListScreen(itemsViewModel: ListTemplateContract = hiltViewModel() as ListTemplateViewModel,
                   navigate: ((path: String) -> Unit)? = null) {
    val feedState = itemsViewModel.listState.collectAsState()
    ItemListTemplate(feedState.value, navigate) {
        itemsViewModel.fetchItems()
    }
}