package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.CoinType

@Composable
fun CoinAmount(modifier: Modifier = Modifier, type: CoinType, color: Color) {

    val amountDescription = when (type) {
        is CoinType.Gold -> {
            stringResource(id = R.string.gold_cost, formatArgs = arrayOf(type.amount))
        }
        is CoinType.Silver -> {
            stringResource(id = R.string.silver_cost, formatArgs = arrayOf(type.amount))
        }
        is CoinType.Copper -> {
            stringResource(id = R.string.copper_cost, formatArgs = arrayOf(type.amount))
        }
    }

    Row(
        modifier.semantics {
            contentDescription = amountDescription
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.crown_coin),
            contentDescription = null,
            colorFilter =
            ColorFilter.tint(color)
        )
        Text(text = "${type.amount}")
    }
}