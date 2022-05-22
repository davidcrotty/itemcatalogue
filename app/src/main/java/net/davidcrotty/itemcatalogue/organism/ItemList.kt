package net.davidcrotty.itemcatalogue.organism

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.atom.LoadingIndicator
import net.davidcrotty.itemcatalogue.model.FeedItem

@Composable
fun ItemList(itemList: List<FeedItem>,
             navigate:((path: String) -> Unit)? = null,
             fetchMore: (() -> Unit)? = null) {
    Surface {
        val listState = rememberLazyListState()
        Log.d("ListTemplate", "item size: ${itemList.size}")

        LazyColumn {
            itemsIndexed(
                itemList
            ) { index, dungeonItem ->
                ItemCard(dungeonItem, onClick = {
                    navigate?.invoke("item")
                })

                if (index < itemList.lastIndex) {
                    ListDivider()
                }

                Log.d("ItemList", "rendered item $index")
            }

            item {
                val loadingContentDescription = stringResource(id = R.string.item_feed_loading)
                Box(contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.padding_medium))) {
                    LoadingIndicator(
                        modifier = Modifier.semantics {
                            contentDescription = loadingContentDescription
                        }
                    )
                }
            }
        }


        // TODO should this logic be abstracted?
        if (listState.layoutInfo.visibleItemsInfo.isEmpty()) {
            LaunchedEffect(key1 = itemList) {
                fetchMore?.invoke()
            }
        }
    }
}