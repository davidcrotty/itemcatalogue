package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import net.davidcrotty.itemcatalogue.atom.LoadingIndicator
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.organism.ItemList

@Composable
fun ListTemplate(itemList: List<FeedItem>,
                 isLoading: Boolean,
                 navigate:((path: String) -> Unit)? = null,
                 fetchMore: (() -> Unit)? = null) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ItemList(itemList, navigate, fetchMore)
        if (isLoading) {
            LoadingIndicator()
        }
    }
}