package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import net.davidcrotty.itemcatalogue.template.ItemDetailTemplate
import net.davidcrotty.itemcatalogue.viewmodel.ItemDetailViewModel


@Composable
fun ItemDetailScreen(
    background: Color = MaterialTheme.colors.background,
    detailViewModel: ItemDetailViewModel
) {
    detailViewModel.renderItemDetail()
    val itemDetailState = detailViewModel.itemDetailState.collectAsState()
    ItemDetailTemplate(Modifier.background(background), itemDetailState = itemDetailState.value)
}