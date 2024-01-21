package net.davidcrotty.itemcatalogue.template

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import net.davidcrotty.itemcatalogue.molecule.FeedLoadingIndicator
import net.davidcrotty.itemcatalogue.molecule.FeedRetryIndicator
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.theme.LocalColors

@Composable
fun ItemListTemplate(
    itemListState: ListTemplateState,
    navigate: ((path: String) -> Unit)? = null,
    fetchMore: (() -> Unit)
) {

    Surface {
        val listState = rememberLazyListState()

        val dungeonItemFeed = stringResource(id = R.string.dungeon_item_feed)
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .semantics {
                    contentDescription = dungeonItemFeed
                },
            state = listState
        ) {
            items(
                items = itemListState.feedItems,
                key = { it.id },
                contentType = { it.type }) { dungeonItem ->
                ItemCard(item = dungeonItem, onClick = {
                    navigate?.invoke("item/${dungeonItem.id}")
                })
                ListDivider()
            }

            when (itemListState.loadingState) {
                is LoadingState.Retry -> {
                    item(contentType = { "retry" }) {
                        FeedRetryIndicator(fetchMore)
                    }
                }

                else -> {
                    item(contentType = { "loading" }) {
                        FeedLoadingIndicator()
                    }
                }
            }
        }

        LaunchedEffect(listState) {
            snapshotFlow { listState.layoutInfo.visibleItemsInfo }
                .filter { it.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1 }
                .collect {
                    fetchMore.invoke()
                }
        }
    }
}

@Composable
private fun ListDivider() {
    Divider(
        color = LocalColors.current.divider
    )
}