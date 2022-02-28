package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.ui.theme.Red500
import net.davidcrotty.itemcatalogue.ui.theme.White900
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.ui.theme.TableTypography

@Composable
fun StatTable() {
    // TODO make colours implicit
    Column(modifier = Modifier.background(color = White900)) {
        Divider(color = Red500, thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = Red500, thickness = 1.dp)
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Text(text = "Battleaxe", style = TableTypography.h1)
            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
            Divider(color = Red500, thickness = 1.dp)
        }
        Divider(color = Red500, thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = Red500, thickness = 1.dp)
    }
}