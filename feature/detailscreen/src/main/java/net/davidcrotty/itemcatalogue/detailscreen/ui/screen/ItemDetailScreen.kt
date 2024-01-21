package net.davidcrotty.itemcatalogue.detailscreen.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailContract
import net.davidcrotty.itemcatalogue.detailscreen.ui.atom.DividerLabel
import net.davidcrotty.itemcatalogue.detailscreen.ui.molecule.DetailImage
import net.davidcrotty.itemcatalogue.detailscreen.ui.template.ItemDetailTemplate
import net.davidcrotty.itemcatalogue.theme.LocalCatalogTemplateValues


@Composable
fun ItemDetailScreen(
    detailViewModel: ItemDetailContract
) {
    detailViewModel.renderItemDetail()
    val itemDetailState = detailViewModel.itemDetailState.collectAsState()

    val itemDetail = itemDetailState.value.itemDetail

    ItemDetailTemplate(
        image = {
            DetailImage(
                image = itemDetail.image
            )
        },
        title = {
            Text(
                itemDetail.title.orEmpty(),
                style = LocalCatalogTemplateValues.current.itemDetailToken.detailTitle
            )
        },
        divider = {
            DividerLabel(
                text = itemDetail.type.orEmpty(),
                modifier = Modifier.fillMaxWidth()
            )
        },
        description = {
            Text(
                itemDetail.description.orEmpty(),
                style = LocalCatalogTemplateValues.current.itemDetailToken.detailBody
            )
        },
        itemDetail = itemDetail
    )
}