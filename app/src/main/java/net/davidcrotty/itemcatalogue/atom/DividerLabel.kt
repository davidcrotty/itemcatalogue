package net.davidcrotty.itemcatalogue.atom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.ui.theme.DetailColors
import net.davidcrotty.itemcatalogue.R


@Preview
@Composable
fun DividerLabelPreview() {
    DividerLabel(
        Modifier
            .padding(top = 10.dp)
            .fillMaxSize(), text = "Weapon")
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun DividerLabel(modifier: Modifier = Modifier, text: String) {
    val lineColour = DetailColors.current.divider
    val textMeasurer = rememberTextMeasurer()
    val textLayoutResult: TextLayoutResult =
        textMeasurer.measure(text = AnnotatedString(text))
    val textOffset = dimensionResource(id = R.dimen.padding_medium).value

    Canvas(modifier = modifier) {
        drawLine(
            strokeWidth = 1.dp.toPx(),
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            color = lineColour
        )
        drawText(
            textLayoutResult,
            topLeft = Offset(x = size.width - textLayoutResult.size.width - textOffset, y = 0f)
        )
    }
}