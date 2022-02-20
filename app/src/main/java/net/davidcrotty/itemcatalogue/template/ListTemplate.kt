package net.davidcrotty.itemcatalogue.template

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

@Composable
fun ListTemplate(itemList: List<Item>, navigate:((path: String) -> Unit)? = null, fetchMore: (() -> Unit)? = null) {
    Surface {
        val listState = rememberLazyListState()
        Log.d("ListTemplate", "item size: ${itemList.size}")

        // TODO this logic should be passed to by a contract from the appropriate feature, this way items stay pure UI components

        LazyColumn(Modifier.semantics {
            set(SemanticsPropertyKey("ContentDescription"), "Item list")
        }) {
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