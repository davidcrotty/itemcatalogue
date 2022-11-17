package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraphImpl
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel


@Composable
fun ItemDetailScreen(
    titleText: String = "Fire Sword", // TODO lookup compose preview model to keep signature clean
    background: Color = MaterialTheme.colors.background,
    appGraph: DndCatalogueAppContainer,
    itemID: String
) {
    val detailViewModel = appGraph.itemDetailGraph().itemDetailViewModel()
    detailViewModel.renderItemDetail(itemID)
    val itemScreen = detailViewModel.itemDetailState.collectAsState()
    Box(modifier = Modifier.background(background)) {
        Box {
            ConstraintLayout {
                val (detailImage, breadcrumbs, spacer, title) = createRefs()
                DetailImage(modifier = Modifier.constrainAs(detailImage) {
                    top.linkTo(parent.top)
                }, image = itemScreen.value.itemDetail.image)
                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.padding_medium))
                    .constrainAs(spacer) {
                        top.linkTo(breadcrumbs.bottom)
                    })
                Text(titleText, style = Typography.h2,
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(detailImage.bottom)
                    })
                // TODO underline with stick out tab for type beneath
            }
        }
    }
}