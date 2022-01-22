package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import net.davidcrotty.itemcatalogue.R

@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        Box {
            Image(
                painter = rememberImagePainter(url),
                contentDescription = stringResource(id = R.string.item_background),
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Text("Battleaxe")
            Text("Damage Combat") // allcaps
            Spacer(modifier = Modifier.height(60.dp)) // TODO dynamic based on real estate
            Text("Description") // TODO behaviour based on scrolling
            Spacer(modifier = Modifier.height(30.dp)) // TODO dynamic based on real estate
            Text("Battleaxe")
        }
    }
}