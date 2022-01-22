package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.di.ItemListGraphImpl
import net.davidcrotty.itemcatalogue.organism.ItemCard
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.template.ListTemplate
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTemplateTheme {
                ItemListScreen()
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