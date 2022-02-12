package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.screen.ItemListScreen
import net.davidcrotty.itemcatalogue.ui.theme.CatalogueTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTemplateTheme {
                ItemListScreen(ItemScreenGraphImpl())
            }
        }
    }
}