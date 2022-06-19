package net.davidcrotty.itemcatalogue.template

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.molecule.FeedLoadingIndicator
import net.davidcrotty.itemcatalogue.organism.ItemCard

@Composable
fun ItemListTemplate(
    itemListState: ListTemplateState,
    navigate: ((path: String) -> Unit)? = null,
    fetchMore: (() -> Unit)? = null
) {
    Surface {
        val listState = rememberLazyListState()
        Log.d("ListTemplate", "item size: ${itemListState.feedItems.size}")

        val dungeonItemFeed = stringResource(id = R.string.dungeon_item_feed)
        LazyColumn(Modifier.semantics {
            contentDescription = dungeonItemFeed
        }) {
            itemsIndexed(
                itemListState.feedItems
            ) { index, dungeonItem ->
                ItemCard(dungeonItem, onClick = {
                    navigate?.invoke("item")
                })

                if (index < itemListState.feedItems.lastIndex) {
                    ListDivider()
                }

                if (index >= itemListState.feedItems.size - 1) {
                    LaunchedEffect(itemListState.feedItems.size) {
                        fetchMore?.invoke()
                    }
                }

                Log.d("ItemList", "rendered item $index")
            }

            item {
                when(itemListState.loadingState) {
                    is LoadingState.Retry -> {

                    } else -> {
                        FeedLoadingIndicator()
                    }
                }
            }
        }

        if (listState.layoutInfo.visibleItemsInfo.isEmpty()) {
            LaunchedEffect(key1 = itemListState.feedItems) {
                fetchMore?.invoke()
            }
        }
    }
}