package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

@Composable
fun ListTemplate(itemList: List<Item>, fetchMore: (() -> Unit)? = null) {
    Surface {
        val listState = rememberLazyListState()

        // TODO this logic should be passed to by a contract from the appropriate feature, this way items stay pure UI components

        LazyColumn {
            itemList.forEachIndexed { index, dungeonItem ->
                item {
                    ItemCard(dungeonItem)
                }

                // TODO factory to abstract render details
                if (index < itemList.lastIndex) {
                    item {
                        ListDivider()
                    }
                }

            }
        }

        // TODO should this logic be abstracted?
        if (listState.layoutInfo.visibleItemsInfo.isEmpty()) {
            fetchMore?.invoke()
        }
    }
}