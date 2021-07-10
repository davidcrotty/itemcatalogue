package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.coil.rememberCoilPainter

// TODO move to listFeature, atoms lower into a styleguide/catalogue
// https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large
@Composable
fun ItemCard() {
    Row {
//        Image(
//            painter = rememberCoilPainter("https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large"),
//            contentDescription = "Image description"
//        )
        Column {
            Text("Type")
            Text("Title")
            Text("Description")
        }
    }
}