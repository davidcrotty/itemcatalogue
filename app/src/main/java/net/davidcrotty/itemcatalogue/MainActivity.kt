package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.template.ListTemplate
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme
import net.davidcrotty.itemcatalogue.viewmodel.ItemsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTemplateTheme {
                val itemsViewModel = ItemsViewModel()
                ListTemplate(itemsViewModel)
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