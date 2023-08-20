package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.theme.ItemCardToken
import net.davidcrotty.itemcatalogue.theme.LocalCatalogTemplateValues
import net.davidcrotty.itemcatalogue.theme.LocalValues

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    designToken: ItemCardToken = LocalCatalogTemplateValues.current.itemCardToken,
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
                .height(designToken.itemHeight)
                .padding(designToken.itemPadding)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val thumbnailShape = RoundedCornerShape(LocalValues.current.large.value)
            Thumbnail(
                Modifier.aspectRatio(1f)
                    .border(
                        border = BorderStroke(
                            designToken.imageBorderStroke,
                            designToken.imageBorderColor
                        ),
                        shape = thumbnailShape
                    )
                    .clip(thumbnailShape),
                imageSource = item.url)
            Column(modifier = Modifier.padding(start = designToken.itemPadding),
            verticalArrangement = Arrangement.Center) {
                Text(item.type, maxLines = 1, style = designToken.itemTitle)
                Text(item.title, maxLines = 1, style = designToken.itemSubtitle)
            }
        }
    }
}

@Composable
private fun Thumbnail(
              modifier: Modifier = Modifier,
              imageSource: String) {
    Image(
        painter = rememberAsyncImagePainter(imageSource),
        contentDescription = stringResource(id = R.string.list_image),
        // will constrain its height to tow height
        modifier = modifier
    )
}

const val ITEM_DESCRIPTION_PREVIEW =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam diam turpis, tincidunt ut rhoncus nec, iaculis ac ante. Maecenas eu tempor metus. Nunc ac sapien viverra, suscipit purus nec, convallis nis"