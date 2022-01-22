package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemDetailScreen() {
    Box {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(50.dp).background(Color.Red)) {
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