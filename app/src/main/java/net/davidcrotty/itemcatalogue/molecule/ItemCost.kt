package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.CoinAmount
import net.davidcrotty.itemcatalogue.ui.theme.Copper100
import net.davidcrotty.itemcatalogue.ui.theme.Silver100
import net.davidcrotty.itemcatalogue.ui.theme.Yellow500


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
        CoinAmount(Modifier.semantics {
            contentDescription = goldAmount
        }, gold, Yellow500)
        CoinAmount(Modifier.semantics {
            contentDescription = goldAmount
        }, silver, Silver100)
        CoinAmount(Modifier.semantics {
            contentDescription = goldAmount
        }, copper, Copper100)
    }
}