package net.davidcrotty.itemcatalogue.organism

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun PreloadApplicationErrorDialog() {
    AlertDialog(onDismissRequest = {  },
        title = {
            Text(text = "Unable to launch application", modifier = Modifier.semantics { contentDescription = "unable to launch application heading" })
        },
        text = {
            // TODO pass reasons network or unknown error
            Text(text = "Please check network connectivity and try again", modifier = Modifier.semantics { contentDescription = "connectivity error" })
        },
        buttons = {})
}