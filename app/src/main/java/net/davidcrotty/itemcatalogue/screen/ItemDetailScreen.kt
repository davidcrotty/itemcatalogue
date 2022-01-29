package net.davidcrotty.itemcatalogue.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import net.davidcrotty.itemcatalogue.R

@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        var sizeImage by remember { mutableStateOf(IntSize.Zero) }
        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color.Black),
            startY = sizeImage.height.toFloat()/3,
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
        }
        Box(modifier = Modifier.matchParentSize().background(gradient))
        Column {
            Text("Battleaxe") // https://handstandsam.com/2021/08/09/jetpack-compose-text-shadows/ bottom shows text shadows
            Text("Damage Combat") // allcaps
            Spacer(modifier = Modifier.height(60.dp)) // TODO dynamic based on real estate
            Text("Description") // TODO behaviour based on scrolling
            Spacer(modifier = Modifier.height(30.dp)) // TODO dynamic based on real estate
            Text("Battleaxe")
        }
    }
}