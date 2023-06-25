package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.theme.TableTypography

@Composable
fun TableItem(category: String, text: String) {
    Row {
        Text(text = category, style = TableTypography.subtitle1)
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_xsmall)))
        Text(text = text, style = TableTypography.body1)
    }
}