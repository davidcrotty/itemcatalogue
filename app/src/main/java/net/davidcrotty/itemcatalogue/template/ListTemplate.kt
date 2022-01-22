package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.model.ItemModel
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

@Composable
fun ListTemplate(viewModel: ItemsViewModel) {
    Surface {
        val itemList = viewModel.items.collectAsState(initial = emptyList()).value
        val listState = rememberLazyListState()

        LazyColumn(state = listState) {
            itemsIndexed(itemList) { index, item ->
                // TODO factory to abstract render details
                ItemCard(item)
                if (index < itemList.lastIndex) {
                    ListDivider()
                }
            }
        }

        // TODO should this logic be abstracted?
        if (listState.layoutInfo.visibleItemsInfo.isEmpty()) {
            viewModel.fetchItems()
        }
    }
}