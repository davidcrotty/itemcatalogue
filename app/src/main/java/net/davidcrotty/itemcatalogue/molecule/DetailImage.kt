package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.ui.theme.LocalDetailColors

@Composable
fun DetailImage(
    image: ImageResult,
    modifier: Modifier = Modifier,
    background: Color = LocalDetailColors.current.detailImageBackground
) {
    when (image) {
        is ImageResult.Image -> {
            AsyncImage(
                modifier = modifier
                    .aspectRatio(4f / 3f)
                    .background(background), model = image.url, contentDescription = stringResource(
                    id = R.string.detail_image
                ),
                contentScale = ContentScale.Crop
            )
        }
        is ImageResult.Unavailable -> {
            Box(
                modifier = modifier
                    .aspectRatio(4f / 3f)
                    .background(background),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.detail_image_unavailable_48px),
                    contentDescription = stringResource(id = R.string.detail_image_unavailable),
                    colorFilter = ColorFilter.tint(LocalDetailColors.current.svgTint)
                )
            }
        }
    }
}