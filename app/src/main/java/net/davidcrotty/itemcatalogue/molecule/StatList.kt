package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.TableItem
import net.davidcrotty.itemcatalogue.model.StatLine
import net.davidcrotty.itemcatalogue.ui.theme.Red500

@Composable
fun StatList(statLineList: List<StatLine>) {
    Divider(color = Red500, thickness = 1.dp)
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    statLineList.forEachIndexed { i, item ->
        TableItem(category = item.attribute, text = item.value)
        if (i != statLineList.size - 1) {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xxsmall)))
        }
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    Divider(color = Red500, thickness = 1.dp)
}