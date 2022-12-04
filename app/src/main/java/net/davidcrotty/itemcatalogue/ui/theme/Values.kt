package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CornerRadius(val value: Float)

val DefaultCornerRadiusSizes = CornerRadiusSizes()

@Immutable
class CornerRadiusSizes(
    val large: CornerRadius = CornerRadius(32.dp.value)
)

val LocalValues = compositionLocalOf { DefaultCornerRadiusSizes }

val DefaultTableColors = TableColors()

@Immutable
class TableColors(
    val divider: Color = Red500,
    val background: Color = White900
)

val LocalColors = compositionLocalOf { DefaultTableColors }

/**
 * Colors for detail screen palete
 */
val DefaultDetailColors = DetailPalette()

@Immutable
class DetailPalette(
    val divider: Color = Black800,
    val textOnDivider: Color = White900,
    val svgTint: Color = Black800,
    val detailImageBackground: Color = White500
)

val LocalDetailColors = compositionLocalOf { DefaultDetailColors }

val DefaultDecorativeType = DecorativeText()

@Immutable
class DecorativeText(
    val label: SpanStyle = SpanStyle(
        fontFamily = tiamat,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp,
        color = White900,
        fontFeatureSettings = "c2sc, smcp"
    )
)

val DecorativeType = compositionLocalOf { DefaultDecorativeType }