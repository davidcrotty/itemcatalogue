package net.davidcrotty.itemcatalogue.atom

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.R

@Composable
@Preview
fun RetryButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.restart_alt_48px), contentDescription = stringResource(
            id = R.string.retry_button
        ))
    }
}