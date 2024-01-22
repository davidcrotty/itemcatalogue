package net.davidcrotty.itemcatalogue.listscreen.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import net.davidcrotty.itemcatalogue.listscreen.presentation.ListTemplateContract
import net.davidcrotty.itemcatalogue.listscreen.presentation.ListTemplateViewModel

@Composable
fun ItemListScreen(itemsViewModel: ListTemplateContract = hiltViewModel() as ListTemplateViewModel,
                   navigate: ((path: String) -> Unit)? = null) {
    val feedState = itemsViewModel.listState.collectAsState()
    ItemListTemplate(feedState.value, navigate) {
        itemsViewModel.fetchItems()
    }
}