package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import net.davidcrotty.itemcatalogue.R

// TODO move to listFeature, atoms lower into a styleguide/catalogue
@Preview
@Composable
fun ItemCard(item: ItemModel = ItemModel(url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large", type = "Type", title = "Title", description = ITEM_DESCRIPTION_PREVIEW)) {
    Surface(color = Color.Red) {
        Row(modifier = Modifier
            .height(160.dp)
            .padding(16.dp)
            .fillMaxWidth()) {
            Image(
                painter = rememberCoilPainter(item.url),
                contentDescription = stringResource(id = R.string.list_item),
                // will constrain its height to tow height
                modifier = Modifier.aspectRatio(1f)
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(item.type, maxLines = 1)
                Text(item.title, maxLines = 1)
                Text(item.description, maxLines = 3)
            }
        }
    }
}

class ItemModel(val url: String, val type: String, val title: String, val description: String)

private const val ITEM_DESCRIPTION_PREVIEW = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam diam turpis, tincidunt ut rhoncus nec, iaculis ac ante. Maecenas eu tempor metus. Nunc ac sapien viverra, suscipit purus nec, convallis nis"