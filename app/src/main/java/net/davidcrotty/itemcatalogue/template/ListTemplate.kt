package net.davidcrotty.itemcatalogue.template

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.items.Item
import net.davidcrotty.itemcatalogue.organism.ItemCard

@Composable
fun ListTemplate(itemList: List<Item>, navigate:((path: String) -> Unit)? = null, fetchMore: (() -> Unit)? = null) {
    Surface {
        val listState = rememberLazyListState()
        Log.d("ListTemplate", "item size: ${itemList.size}")

        // TODO this logic should be passed to by a contract from the appropriate feature, this way items stay pure UI components

        LazyColumn {
            itemList.forEachIndexed { index, dungeonItem ->
                item {
                    ItemCard(dungeonItem, onClick = {
                        navigate?.invoke("item")
                    })
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