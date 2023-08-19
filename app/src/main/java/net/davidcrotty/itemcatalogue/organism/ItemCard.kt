package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.molecule.ItemCost
import net.davidcrotty.itemcatalogue.theme.CornerRadius
import net.davidcrotty.itemcatalogue.theme.LocalValues
import net.davidcrotty.itemcatalogue.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ItemCard(
    item: FeedItem = FeedItem(
        id = "1",
        url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
        type = "Type",
        title = "Title",
        description = ITEM_DESCRIPTION_PREVIEW
    ),
    onClick: (() -> Unit)? = null
) {
    Surface (onClick = {
        onClick?.invoke()
    }){
        Row(
            modifier = Modifier
                .height(160.dp)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Thumbnail(imageSource = item.url)
            Column(modifier = Modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.Bottom) {
                Text(item.type, maxLines = 1, style = Typography.body2)
                Text(item.title, maxLines = 1, style = Typography.h2)
                Box(Modifier.size(152.dp, 32.dp)){
                    ItemCost(gold = 1, silver = 2, copper = 3)
                }
            }
        }
    }
}

@Composable
private fun Thumbnail(imageSource: String,
              cornerRadius: CornerRadius = LocalValues.current.large) {
    Image(
        painter = rememberAsyncImagePainter(imageSource),
        contentDescription = stringResource(id = R.string.list_image),
        // will constrain its height to tow height
        modifier = Modifier.aspectRatio(1f).clip(RoundedCornerShape(cornerRadius.value))
    )
}

const val ITEM_DESCRIPTION_PREVIEW =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam diam turpis, tincidunt ut rhoncus nec, iaculis ac ante. Maecenas eu tempor metus. Nunc ac sapien viverra, suscipit purus nec, convallis nis"