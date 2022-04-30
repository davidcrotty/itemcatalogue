package net.davidcrotty.itemcatalogue.atom

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(modifier = Modifier.semantics {
        contentDescription = "loading"
    })
}