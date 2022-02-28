package net.davidcrotty.itemcatalogue.atom

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.ui.theme.TableTypography

@Composable
fun TableText(text: String) {
    Text(text = text, style = TableTypography.body1)
}