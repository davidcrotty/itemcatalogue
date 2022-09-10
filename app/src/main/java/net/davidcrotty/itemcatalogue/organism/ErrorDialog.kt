package net.davidcrotty.itemcatalogue.organism

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import net.davidcrotty.itemcatalogue.R

@Composable
fun PreloadApplicationErrorDialog() {
    AlertDialog(onDismissRequest = { // noop don't want to dismiss
        },
        title = {
            Text(text = stringResource(id = R.string.dialog_title_unable_to_launch_application), modifier = Modifier.semantics { contentDescription = "unable to launch application heading" })
        },
        text = {
            // TODO pass reasons network or unknown error
            Text(text = stringResource(id = R.string.dialog_description_connectivity_error), modifier = Modifier.semantics { contentDescription = "connectivity error" })
        },
        buttons = {})
}