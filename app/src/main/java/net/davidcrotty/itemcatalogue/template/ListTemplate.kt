package net.davidcrotty.itemcatalogue.template

import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.organism.ItemList

@Composable
fun ListTemplate(itemList: List<FeedItem>,
                 canLoadMore: Boolean,
                 navigate:((path: String) -> Unit)? = null,
                 fetchMore: (() -> Unit)? = null) {
    ItemList(itemList, navigate, fetchMore)
}