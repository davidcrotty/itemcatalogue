package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.atom.BackgroundImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography

@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        BackgroundImage(url)
        Column {
            Text("Breadcrumbs", style = Typography.caption) // allcaps
            Text("Battleaxe") // https://handstandsam.com/2021/08/09/jetpack-compose-text-shadows/ bottom shows text shadows
            Text("Damage Combat") // allcaps
            Spacer(modifier = Modifier.height(60.dp)) // TODO dynamic based on real estate
            Text("Description") // TODO behaviour based on scrolling
            Spacer(modifier = Modifier.height(30.dp)) // TODO dynamic based on real estate
            Text("Battleaxe")
        }
    }
}