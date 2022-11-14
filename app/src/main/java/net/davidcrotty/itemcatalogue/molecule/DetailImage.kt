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
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import net.davidcrotty.itemcatalogue.ui.theme.LocalValues

@Preview
@Composable
fun DetailImage(
    modifier: Modifier = Modifier,
    url: String = "https://www.dndbeyond.com/attachments/2/666/armor.jpg",
    background: Color = MaterialTheme.colors.surface
) {
    // TODO scale to fit
    AsyncImage(
        modifier = modifier
            .aspectRatio(4f / 3f)
            .clip(RoundedCornerShape(LocalValues.current.large.value))
            .background(background), model = url, contentDescription = "Detail Image"
    )
}