package net.davidcrotty.itemcatalogue.listscreen.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import net.davidcrotty.itemcatalogue.listscreen.R

@Composable
fun RetryButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.restart_alt),
            tint = MaterialTheme.colors.primary,
            contentDescription = stringResource(
            id = R.string.retry_button
        ))
    }
}