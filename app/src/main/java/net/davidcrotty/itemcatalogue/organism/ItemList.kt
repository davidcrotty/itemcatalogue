package net.davidcrotty.itemcatalogue.organism

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import net.davidcrotty.itemcatalogue.atom.ListDivider
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