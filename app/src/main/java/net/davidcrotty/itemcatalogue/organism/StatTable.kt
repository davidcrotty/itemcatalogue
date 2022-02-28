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
import net.davidcrotty.itemcatalogue.atom.TableItem
import net.davidcrotty.itemcatalogue.model.StatLine
import net.davidcrotty.itemcatalogue.molecule.StatList
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
            StatList(listOf(
                StatLine("Type", "Martial Melee Weapon"),
                StatLine("Cost", "10 gp"),
                StatLine("Weight", "4 lbs"),
                StatLine("Damage", "1d8 Slashing")
            ))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text(text = "Properties", style = TableTypography.h1)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xxsmall)))
            Text(text = "Versatile (1d10)", style = TableTypography.body1)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        }
        Divider(color = Red500, thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = Red500, thickness = 1.dp)
    }
}