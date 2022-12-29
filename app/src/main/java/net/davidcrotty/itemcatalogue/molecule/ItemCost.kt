package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R


@Preview
@Composable
fun ItemCostPreview() {
    ItemCost(gold = 1, silver = 2, copper = 3)
}

@Composable
fun ItemCost(
    gold: Int,
    silver: Int,
    copper: Int
) {
    val itemCost = stringResource(id = R.string.item_cost)
    val goldAmount = stringResource(id = R.string.gold_cost, formatArgs = arrayOf(gold))
    Row(
        Modifier
            .semantics {
                contentDescription = itemCost
            }
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            Modifier.semantics {
                contentDescription = goldAmount
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.crown_coin), null)
            Text(text = "$gold")
        }
        Text(text = "S: $silver")
        Text(text = "C: $copper")
    }
}