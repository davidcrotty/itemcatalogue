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
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R

@Composable
fun CoinAmount(modifier: Modifier, amount: Int, color: Color) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.crown_coin), contentDescription = null, colorFilter =
        ColorFilter.tint(color))
        Text(text = "$amount")
    }
}