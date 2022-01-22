package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.atom.ListDivider
import net.davidcrotty.itemcatalogue.model.ItemModel
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTemplateTheme {
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
                        ))
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
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatalogueTemplateTheme {
       ItemCard()
    }
}