package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.theme.LocalAppColours
import net.davidcrotty.itemcatalogue.theme.LocalFont

@Composable
fun ItemCatalogueAppBar(
    title: String = LocalContext.current.getString(R.string.app_name),
    icon: @Composable () -> Unit
) {
    TopAppBar(
        contentPadding = PaddingValues(horizontal = 16.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        icon()
        val titleSemantic = LocalContext.current.getString(R.string.screen_name)
        screenTitle(
            modifier =
            Modifier
                .weight(1f, true)
                .semantics {
                    contentDescription = titleSemantic
                }, title = title
        )
    }
}

@Composable
private fun screenTitle(modifier: Modifier, title: String) {
    Text(
        title,
        modifier,
        textAlign = TextAlign.Center,
        style = LocalFont.current.screenTitle
    )
}