package net.davidcrotty.itemcatalogue.detailscreen.ui.atom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.davidcrotty.itemcatalogue.theme.LocalCatalogTemplateValues
import net.davidcrotty.itemcatalogue.theme.R
import net.davidcrotty.itemcatalogue.detailscreen.R as DetailScreenR


@Preview
@Composable
fun DividerLabelPreview() {
    DividerLabel(
        Modifier
            .padding(top = 10.dp)
            .fillMaxSize(),
        text = "Weapon",
        element = "acid"
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun DividerLabel(modifier: Modifier = Modifier, text: String, element: String) {
    val dividerColour =
        LocalCatalogTemplateValues.current.itemDetailToken.dividerColour.getOrDefault(
            element,
            LocalCatalogTemplateValues.current.itemDetailToken.defaultDividerColor
        )

    val lineColour = dividerColour
    val textMeasurer = rememberTextMeasurer()
    val styledText = buildAnnotatedString {
        withStyle(style = LocalCatalogTemplateValues.current.itemDetailToken.label) {
            append(text)
        }
    }
    val textLayoutResult: TextLayoutResult =
        textMeasurer.measure(text = styledText)
    val textOffset = dimensionResource(id = R.dimen.padding_medium).value

    val slantStart = textLayoutResult.size.height.toFloat() + (textOffset / 2)
    val boxWidth = textLayoutResult.size.width.toFloat() + (textOffset * 2)
    val boxHeight = textLayoutResult.size.height.toFloat() + (textOffset / 2)

    Canvas(modifier = modifier.height(dimensionResource(id = DetailScreenR.dimen.divider_height))) {
        drawLine(
            strokeWidth = 1.dp.toPx(),
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            color = lineColour
        )
        val insetX = size.width - boxWidth
        drawRect(
            topLeft = Offset(insetX, 0f),
            color = dividerColour,
            size = Size(width = boxWidth, height = boxHeight)
        )
        drawText(
            textLayoutResult,
            topLeft = Offset(x = size.width - textLayoutResult.size.width - textOffset, y = 0f)
        )
        val slantCorner = insetX - (textOffset * 2)
        drawPath(
            path = Path().apply {
                moveTo(insetX, slantStart)
                lineTo(insetX, 0f)
                lineTo(slantCorner, 0f)
                lineTo(insetX, slantStart)
                close()
            },
            color = dividerColour
        )
    }
}