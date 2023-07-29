package net.davidcrotty.itemcatalogue.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.theme.LocalAppColours
import net.davidcrotty.itemcatalogue.theme.LocalFont

@Composable
fun ItemCatalogueAppBar(title: String = LocalContext.current.getString(R.string.app_name)) {
    TopAppBar(
        contentPadding = PaddingValues(horizontal = 16.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Box(
            Modifier
                .width(36.dp)
                .height(36.dp)
                .border(
                    width = 1.dp, shape = CircleShape, brush = Brush.linearGradient(
                        colors = listOf(
                            LocalAppColours.current.highlight,
                            LocalAppColours.current.highlight
                        )
                    )
                )
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.ic_sword),
                contentDescription = LocalContext.current.getString(R.string.screen_icon)
            )
        }
        val titleSemantic = LocalContext.current.getString(R.string.screen_name)
        Text(
            title,
            Modifier
                .weight(1f, true)
                .semantics {
                    contentDescription = titleSemantic
                },
            textAlign = TextAlign.Center,
            style = LocalFont.current.screenTitle
        )
    }
}