package net.davidcrotty.itemcatalogue.detailscreen.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.detailscreen.ui.atom.DividerLabel
import net.davidcrotty.itemcatalogue.detailscreen.model.ImageResult
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetail
import net.davidcrotty.itemcatalogue.detailscreen.ui.molecule.DetailImage
import net.davidcrotty.itemcatalogue.detailscreen.R as DetailScreenR
import net.davidcrotty.itemcatalogue.theme.R

@Preview
@Composable
fun PreviewItemDetailTemplate() {
    ItemDetailTemplate(
        image = {
            DetailImage(
                image = ImageResult.Unavailable
            )
        },
        title = {
            Text(
                "Fire sword"
            )
        },
        divider = {
            DividerLabel(
                text = "weapon", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
                element = "acid"
            )
        },
        description = {
            Text(
                LoremIpsum(200).values.joinToString { "$it " }
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
    divider: @Composable () -> Unit,
    description: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(modifier = modifier) {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            ConstraintLayout {
                val (detailImage, dividerRef, breadcrumbs, spacer, titleRef, descriptionRef) = createRefs()
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
                    val itemTitleLabel = stringResource(id = DetailScreenR.string.item_title)
                    Box(
                        Modifier
                            .constrainAs(titleRef) {
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
                    Spacer(modifier = Modifier.constrainAs(titleRef) {
                        top.linkTo(detailImage.bottom)
                    })
                }
                if (itemDetail.type != null) {
                    Box(
                        Modifier
                            .constrainAs(dividerRef) {
                                top.linkTo(titleRef.bottom)
                            }
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                    ) {
                        divider()
                    }
                } else {
                    Spacer(modifier = Modifier.constrainAs(dividerRef) {
                        top.linkTo(titleRef.bottom)
                    })
                }
                if (itemDetail.description != null) {
                    Box(modifier = Modifier
                        .constrainAs(descriptionRef) {
                            top.linkTo(dividerRef.bottom)
                        }
                        .padding(dimensionResource(id = R.dimen.padding_medium))) {
                        description()
                    }
                } else {
                    Spacer(modifier = Modifier.constrainAs(descriptionRef) {
                        top.linkTo(dividerRef.bottom)
                    })
                }
            }
        }
    }
}