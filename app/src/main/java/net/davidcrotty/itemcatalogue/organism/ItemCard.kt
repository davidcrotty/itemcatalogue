package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

// TODO move to listFeature, atoms lower into a styleguide/catalogue
// https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large
@Composable
fun ItemCard() {
    Surface(color = Color.Red) {
        Row(modifier = Modifier.height(160.dp).fillMaxWidth()) {
            Image(
                painter = rememberCoilPainter("https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large"),
                contentDescription = "Image description", // TODO resources
                // will constrain its height to tow height
                modifier = Modifier.height(240.dp)
            )
            Column {
                Text("Type", maxLines = 1)
                Text("Title", maxLines = 1)
                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam diam turpis, tincidunt ut rhoncus nec, iaculis ac ante. Maecenas eu tempor metus. Nunc ac sapien viverra, suscipit purus nec, convallis nis")
            }
        }
    }
}