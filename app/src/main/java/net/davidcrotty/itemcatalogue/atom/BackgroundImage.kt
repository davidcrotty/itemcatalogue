package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import coil.compose.rememberAsyncImagePainter
import net.davidcrotty.itemcatalogue.R

@Composable
fun BackgroundImage(url: String, gradient: Brush = Brush.verticalGradient(), onGloballyPositioned: ((IntSize) -> Unit)?) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = stringResource(id = R.string.item_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.onGloballyPositioned {
                onGloballyPositioned?.invoke(it.size)
            }
        )
        Box(modifier = Modifier.matchParentSize().background(gradient))
    }
}