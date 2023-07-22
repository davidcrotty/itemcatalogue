package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import net.davidcrotty.itemcatalogue.atom.DividerLabel
import net.davidcrotty.itemcatalogue.detailscreen.presentation.ItemDetailContract
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.template.ItemDetailTemplate
import net.davidcrotty.itemcatalogue.theme.LocalDetailColors
import net.davidcrotty.itemcatalogue.theme.Typography


@Composable
fun ItemDetailScreen(
    background: Color = MaterialTheme.colors.background,
    detailViewModel: ItemDetailContract
) {
    detailViewModel.renderItemDetail()
    val itemDetailState = detailViewModel.itemDetailState.collectAsState()

    val itemDetail = itemDetailState.value.itemDetail

    ItemDetailTemplate(
        Modifier.background(background), image = {
            DetailImage(
                modifier = Modifier.background(LocalDetailColors.current.detailImageBackground),
                image = itemDetail.image
            )
        },
        title = {
            Text(
                itemDetail.title.orEmpty(), style = Typography.h2
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
                style = Typography.body1
            )
        },
        itemDetail = itemDetail
    )
}