package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.atom.BackgroundImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography
import net.davidcrotty.itemcatalogue.R

@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        BackgroundImage(url)
        Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Column {
                Text("Items > Weapons", style = Typography.caption) // allcaps // TODO write bread crumbs function/widget
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
                Text("Battleaxe", style = Typography.h1) // https://handstandsam.com/2021/08/09/jetpack-compose-text-shadows/ bottom shows text shadows
                Text("Damage Combat") // allcaps
                Spacer(modifier = Modifier.height(60.dp)) // TODO dynamic based on real estate
                Text("Description") // TODO behaviour based on scrolling
                Spacer(modifier = Modifier.height(30.dp)) // TODO dynamic based on real estate
                Text("Battleaxe")
            }
        }
    }
}