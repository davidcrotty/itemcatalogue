package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.ImageResult

@Composable
fun DetailImage(
    image: ImageResult,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.surface
) {
    when (image) {
        is ImageResult.Image -> {
            AsyncImage(
                modifier = modifier
                    .aspectRatio(4f / 3f)
                    .background(background), model = image.url, contentDescription = "Detail Image",
                contentScale = ContentScale.Crop
            )
        }
        is ImageResult.Unavailable -> {
            Image(
                painter = painterResource(id = R.drawable.detail_image_unavailable_48px),
                contentDescription = "Detail Image Unavailable"
            )
        }
    }
}