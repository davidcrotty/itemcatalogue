package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

// TODO move to listFeature, atoms lower into a styleguide/catalogue
// https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large
@Composable
fun ItemCard() {
    Row(modifier = Modifier.height(240.dp)) {
        Image(
            painter = rememberCoilPainter("https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large"),
            contentDescription = "Image description", // TODO resources
            modifier = Modifier.aspectRatio(3f/16f)
        )
        Column {
            Text("Type")
            Text("Title")
            Text("Description")
        }
    }
}