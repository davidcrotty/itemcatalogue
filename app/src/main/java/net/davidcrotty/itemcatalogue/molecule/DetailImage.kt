package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Preview
@Composable
fun DetailImage(url: String = "https://www.dndbeyond.com/avatars/thumbnails/9170/66/1000/1000/637199798951570191.png") {
    AsyncImage(model = url, contentDescription = "Detail Image")
}