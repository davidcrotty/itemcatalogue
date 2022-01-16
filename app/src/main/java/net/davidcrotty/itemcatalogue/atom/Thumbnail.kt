package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.ui.theme.CornerRadius
import net.davidcrotty.itemcatalogue.ui.theme.LocalValues

@Composable
fun Thumbnail(imageSource: String,
             cornerRadius: CornerRadius = LocalValues.current.large) {
    Image(
        painter = rememberImagePainter(imageSource, builder = {
            transformations(RoundedCornersTransformation(cornerRadius.value))
        }),
        contentDescription = stringResource(id = R.string.list_item),
        // will constrain its height to tow height
        modifier = Modifier.aspectRatio(1f),
    )
}