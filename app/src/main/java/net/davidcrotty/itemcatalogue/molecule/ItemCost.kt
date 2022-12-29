package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
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
    Row(Modifier.semantics {
        contentDescription = itemCost
    }) {
        Row(Modifier.semantics {
            contentDescription = goldAmount
        }) {
            Text(text = "G: $silver")
        }
        Text(text = "S: $silver")
        Text(text = "C: $copper")
    }
}