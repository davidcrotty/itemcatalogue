package net.davidcrotty.itemcatalogue.atom

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import net.davidcrotty.itemcatalogue.theme.TableTypography

@Composable
fun TableHeading(text: String) {
    Text(text = text, style = TableTypography.h1)
}