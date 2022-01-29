package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.atom.BackgroundImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.ui.theme.Grey500

@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        BackgroundImage(url)
        Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Column {
                Text("Items > Weapons", style = Typography.caption) // allcaps // TODO write bread crumbs function/widget
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
                Text("Battleaxe", style = Typography.h1.copy(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text("Damage Combat", style = Typography.subtitle1.copy(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ))
                Spacer(modifier = Modifier.height(60.dp)) // TODO dynamic based on real estate
                Text("Description") // TODO behaviour based on scrolling
                Spacer(modifier = Modifier.height(30.dp)) // TODO dynamic based on real estate
                Text("Battleaxe")
            }
        }
    }
}