package net.davidcrotty.itemcatalogue.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import net.davidcrotty.itemcatalogue.template.ItemListTemplate

@Composable
fun ItemListScreen(itemsViewModel: ListTemplateContract = hiltViewModel() as ListTemplateViewModel,
                   navigate: ((path: String) -> Unit)? = null) {
    val feedState = itemsViewModel.listState.collectAsState()
    ItemListTemplate(feedState.value, navigate) {
        itemsViewModel.fetchItems()
    }
}