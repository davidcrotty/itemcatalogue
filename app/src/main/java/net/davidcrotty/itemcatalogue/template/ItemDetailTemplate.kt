package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.DividerLabel
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.LocalDetailColors
import net.davidcrotty.itemcatalogue.ui.theme.Typography

@Preview
@Composable
fun PreviewItemDetailTemplate() {
    ItemDetailTemplate(
        image = {
            DetailImage(
                image = ImageResult.Unavailable, modifier = Modifier.background(
                    LocalDetailColors.current.detailImageBackground
                )
            )
        },
        title = {
            Text(
                "Fire sword", style = Typography.h2
            )
        },
        divider = {
            DividerLabel(
                text = "weapon", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            )
        },
        itemDetail = ItemDetail(
            "Fire sword",
            "weapon",
            LoremIpsum(200).values.joinToString { "$it " },
            ImageResult.Image("https://www.scabard.com/user/Pochibella/image/10e63a407bbd6066ddb5444369e942ee.jpg")
        )
    )
}

@Composable
fun ItemDetailTemplate(
    modifier: Modifier = Modifier,
    itemDetail: ItemDetail,
    image: @Composable () -> Unit,
    title: @Composable () -> Unit,
    divider: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(modifier = modifier) {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            ConstraintLayout {
                val (detailImage, divider, breadcrumbs, spacer, title, description) = createRefs()
                Box(modifier = Modifier.constrainAs(detailImage) {
                    top.linkTo(parent.top)
                }) {
                    image()
                }
                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.padding_medium))
                    .constrainAs(spacer) {
                        top.linkTo(breadcrumbs.bottom)
                    })
                if (!itemDetail.title.isNullOrEmpty()) {
                    val itemTitleLabel = stringResource(id = R.string.item_title)
                    Box(
                        Modifier
                            .constrainAs(title) {
                                top.linkTo(detailImage.bottom)
                            }
                            .padding(dimensionResource(id = R.dimen.padding_medium))
                            .semantics {
                                contentDescription = itemTitleLabel
                            }
                    ) {
                        title()
                    }
                } else {
                    Spacer(modifier = Modifier.constrainAs(title) {
                        top.linkTo(detailImage.bottom)
                    })
                }
                if (itemDetail.type != null) {
                    Box(Modifier.constrainAs(divider) {
                        top.linkTo(title.bottom)
                    }) {
                        divider()
                    }
                } else {
                    Spacer(modifier = Modifier.constrainAs(divider) {
                        top.linkTo(title.bottom)
                    })
                }
                if (itemDetail.description != null) {
                    Text(itemDetail.description,
                        style = Typography.body1,
                        modifier = Modifier
                            .constrainAs(description) {
                                top.linkTo(divider.bottom)
                            }
                            .padding(dimensionResource(id = R.dimen.padding_medium)))
                } else {
                    Spacer(modifier = Modifier.constrainAs(description) {
                        top.linkTo(divider.bottom)
                    })
                }
            }
        }
    }
}