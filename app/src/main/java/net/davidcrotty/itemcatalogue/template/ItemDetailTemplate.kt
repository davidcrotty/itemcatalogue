package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography

@Preview
@Composable
fun PreviewItemDetailTemplate() {
    ItemDetailTemplate(itemDetail = ItemDetail("Fire sword", "weapon", "Lorem ipsum", ImageResult.Image("https://media-waterdeep.cursecdn.com/avatars/thumbnails/7/219/1000/1000/636284733648450283.jpeg")))
}

@Composable
fun ItemDetailTemplate(modifier: Modifier = Modifier,
                       itemDetail: ItemDetail) {
    Box(modifier = modifier) {
        Box {
            ConstraintLayout {
                val (detailImage, breadcrumbs, spacer, title) = createRefs()
                DetailImage(modifier = Modifier.constrainAs(detailImage) {
                    top.linkTo(parent.top)
                }, image = itemDetail.image)
                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.padding_medium))
                    .constrainAs(spacer) {
                        top.linkTo(breadcrumbs.bottom)
                    })
                if (itemDetail.title != null) {
                    Text(
                        itemDetail.title, style = Typography.h2,
                        modifier = Modifier
                            .constrainAs(title) {
                                top.linkTo(detailImage.bottom)
                            }
                            .padding(dimensionResource(id = R.dimen.padding_medium)))
                    // TODO underline with stick out tab for type beneath
                }
            }
        }
    }
}