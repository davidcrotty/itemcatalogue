package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography

@Composable
fun ItemDetailTemplate(modifier: Modifier = Modifier,
                       itemDetail: ItemDetail,
                       titleText: String = "Fire Sword") {
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
                Text(itemDetail.title.orEmpty(), style = Typography.h2,
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