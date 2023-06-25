package net.davidcrotty.itemcatalogue.molecule

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.model.StatLine
import net.davidcrotty.itemcatalogue.theme.TableTypography

@Composable
fun StatHeadingLine(statLine: StatLine) {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
    Text(text = statLine.attribute, style = TableTypography.h1)
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xxsmall)))
    Text(text = statLine.value, style = TableTypography.body1)
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
}