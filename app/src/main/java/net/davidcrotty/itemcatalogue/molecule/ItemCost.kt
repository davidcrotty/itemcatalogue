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
import net.davidcrotty.itemcatalogue.model.CoinType
import net.davidcrotty.itemcatalogue.ui.theme.Copper100
import net.davidcrotty.itemcatalogue.ui.theme.Silver100
import net.davidcrotty.itemcatalogue.ui.theme.Yellow500


@Preview
@Composable
fun ItemCostPreview() {
    ItemCost(gold = 1, silver = 2, copper = 3)
}

@Composable
fun ItemCost( // TODO suck up into a model class (look at reasons for vs against composition)
    gold: Int,
    silver: Int,
    copper: Int
) {
    val itemCost = stringResource(id = R.string.item_cost)

    Row(
        Modifier
            .semantics {
                contentDescription = itemCost
            }
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // do inside, why? reasons to change are smaller. Take a sealed class
        CoinAmount(type = CoinType.Gold(gold), color = Yellow500)
        CoinAmount(type = CoinType.Silver(silver), color = Silver100)
        CoinAmount(type = CoinType.Copper(copper), color = Copper100)
    }
}