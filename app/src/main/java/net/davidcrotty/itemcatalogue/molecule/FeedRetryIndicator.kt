package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.RetryButton

@Composable
@Preview
fun FeedRetryIndicator() {
    val retryContentDescription = stringResource(id = R.string.feed_retry_button)
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        RetryButton(
            modifier = Modifier.semantics {
                contentDescription = retryContentDescription
            }
        )
    }
}