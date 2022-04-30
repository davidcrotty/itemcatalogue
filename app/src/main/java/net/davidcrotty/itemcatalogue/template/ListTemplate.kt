package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.R
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
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                val loadingContentDescription = stringResource(id = R.string.item_feed_loading)
                LoadingIndicator(
                    modifier = Modifier.semantics {
                        contentDescription = loadingContentDescription
                    }
                )
            }
        }
    }
}