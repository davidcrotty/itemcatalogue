package net.davidcrotty.itemcatalogue.listscreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.listscreen.R

@Composable
fun FeedLoadingIndicator() {
    val loadingContentDescription = stringResource(id = R.string.item_feed_loading)
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        CircularProgressIndicator(
            modifier = Modifier.semantics {
                contentDescription = loadingContentDescription
            }
        )
    }
}