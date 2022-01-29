package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import coil.compose.rememberImagePainter
import net.davidcrotty.itemcatalogue.R

@Composable
fun BackgroundImage(url: String) {
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, MaterialTheme.colors.background),
        startY = sizeImage.height.toFloat() / 6,
        endY = sizeImage.height.toFloat()
    )

    Box {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = stringResource(id = R.string.item_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.onGloballyPositioned {
                sizeImage = it.size
            }
        )
        Box(modifier = Modifier.matchParentSize().background(gradient))
    }
}