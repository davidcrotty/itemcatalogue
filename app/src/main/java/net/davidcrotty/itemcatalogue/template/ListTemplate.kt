package net.davidcrotty.itemcatalogue.template

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.model.ItemModel
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

@Composable
fun ListTemplate(viewModel: ItemsViewModel) {
    Surface {
        // TODO start publishing this from a viewmodel
        val items = listOf(
            ItemModel(
                url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                type = "Type",
                title = "Title",
                description = "ffff"
            ),
            ItemModel(
                url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                type = "Type",
                title = "Title",
                description = "ffff"
            )
        )
        LazyColumn {
            itemsIndexed(items) { index, item ->
                ItemCard(item)
                if (index < items.lastIndex) {
                    ListDivider()
                }
            }
        }
    }
}