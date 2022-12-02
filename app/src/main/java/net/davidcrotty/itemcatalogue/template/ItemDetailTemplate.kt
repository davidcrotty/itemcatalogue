package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.DividerLabel
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.DetailColors
import net.davidcrotty.itemcatalogue.ui.theme.Typography

@Preview
@Composable
fun PreviewItemDetailTemplate() {
    ItemDetailTemplate(
        itemDetail = ItemDetail(
            "Fire sword",
            "weapon",
            "Lorem ipsum",
            ImageResult.Image("https://www.scabard.com/user/Pochibella/image/10e63a407bbd6066ddb5444369e942ee.jpg")
        )
    )
}

@Composable
fun ItemDetailTemplate(
    modifier: Modifier = Modifier,
    itemDetail: ItemDetail
) {
    Box(modifier = modifier) {
        Box {
            ConstraintLayout {
                val (detailImage, divider, breadcrumbs, spacer, title, description) = createRefs()
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
                }
                if (itemDetail.type != null) {
                    DividerLabel(
                        text = itemDetail.type, modifier = Modifier
                            .constrainAs(divider) {
                                top.linkTo(title.bottom)
                            }
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                    )
                }
                if (itemDetail.description != null) {
                    Text(itemDetail.description, modifier = Modifier
                        .constrainAs(description) {
                            top.linkTo(divider.bottom)
                        }
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)))
                }
            }
        }
    }
}