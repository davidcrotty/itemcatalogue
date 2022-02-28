package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.TableHeading
import net.davidcrotty.itemcatalogue.model.StatLine
import net.davidcrotty.itemcatalogue.molecule.StatHeadingLine
import net.davidcrotty.itemcatalogue.molecule.StatList
import net.davidcrotty.itemcatalogue.ui.theme.LocalColors

@Composable
fun StatTable() {
    // TODO make colours implicit
    Column(modifier = Modifier.background(color = LocalColors.current.background)) {
        Divider(color = LocalColors.current.divider, thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = LocalColors.current.divider, thickness = 1.dp)
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            TableHeading(text = "Battleaxe")
            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
            StatList(listOf(
                StatLine("Type", "Martial Melee Weapon"),
                StatLine("Cost", "10 gp"),
                StatLine("Weight", "4 lbs"),
                StatLine("Damage", "1d8 Slashing")
            ))
            StatHeadingLine(statLine = StatLine("Properties", "Versatile (1d10)"))
        }
        Divider(color = LocalColors.current.divider, thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = LocalColors.current.divider, thickness = 1.dp)
    }
}