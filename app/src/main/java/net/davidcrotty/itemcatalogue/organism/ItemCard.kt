package net.davidcrotty.itemcatalogue.organism

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.atom.Thumbnail
import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID
import net.davidcrotty.itemcatalogue.ui.theme.Typography

// TODO design in a search feature, this is usually a common requirement
// TODO move to listFeature, atoms lower into a styleguide/catalogue
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ItemCard(
    item: Item = Item(
        id = ID(0),
        url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
        type = "Type",
        title = "Title",
        description = ITEM_DESCRIPTION_PREVIEW
    )
) {
    Surface(onClick = {
        Log.d("ItemCard", "clicked")
    }) {
        Row(
            modifier = Modifier
                .height(160.dp)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Thumbnail(imageSource = item.url)
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(item.type, maxLines = 1, style = Typography.body2)
                Text(item.title, maxLines = 1, style = Typography.h2)
                Text(item.description, maxLines = 3)
            }
        }
    }
}

private const val ITEM_DESCRIPTION_PREVIEW =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam diam turpis, tincidunt ut rhoncus nec, iaculis ac ante. Maecenas eu tempor metus. Nunc ac sapien viverra, suscipit purus nec, convallis nis"