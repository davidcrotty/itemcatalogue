package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

@Composable
fun ListTemplate(viewModel: ItemsViewModel) {
    Surface {
        val itemList = viewModel.items.collectAsState(initial = emptyList()).value
        val listState = rememberLazyListState()

        // TODO this logic should be passed to by a contract from the appropriate feature, this way items stay pure UI components

        LazyColumn {
            itemList.forEach { dungeonItem ->
                item {
                    ItemCard(dungeonItem)
                }
                // TODO factory to abstract render details
//                if (index < itemList.lastIndex) {
//                    ListDivider()
//                }
            }
//            itemsIndexed(itemList) { index, item ->
//                ItemCard(item)
//                // TODO factory to abstract render details
//                if (index < itemList.lastIndex) {
//                    ListDivider()
//                }
//            }
        }

        // TODO should this logic be abstracted?
        if (listState.layoutInfo.visibleItemsInfo.isEmpty()) {
            viewModel.fetchItems()
        }
    }
}