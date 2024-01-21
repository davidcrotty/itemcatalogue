package net.davidcrotty.itemcatalogue.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.davidcrotty.itemcatalogue.theme.Black800
import net.davidcrotty.itemcatalogue.theme.Red500
import net.davidcrotty.itemcatalogue.theme.White500
import net.davidcrotty.itemcatalogue.theme.White900
import net.davidcrotty.itemcatalogue.theme.tiamat

object Padding {
    val medium: Dp = 16.dp
}

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
    val divider: Color = Grey600
)

val LocalColors = compositionLocalOf { DefaultTableColors }

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