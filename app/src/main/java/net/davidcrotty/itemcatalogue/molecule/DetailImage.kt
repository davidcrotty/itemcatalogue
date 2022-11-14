package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import net.davidcrotty.itemcatalogue.ui.theme.LocalValues

@Preview
@Composable
fun DetailImage(
    modifier: Modifier = Modifier,
    url: String = "https://i0.wp.com/www.chaoticanwriter.com/chaoticanwriter.com/wp-content/uploads/2022/03/flamge-tongue-magic-items.jpg?fit=1000%2C1000&ssl=1",
    background: Color = MaterialTheme.colors.surface
) {
    AsyncImage(
        modifier = modifier
            .aspectRatio(4f / 3f)
            .background(background), model = url, contentDescription = "Detail Image",
        contentScale = ContentScale.Crop
    )
}