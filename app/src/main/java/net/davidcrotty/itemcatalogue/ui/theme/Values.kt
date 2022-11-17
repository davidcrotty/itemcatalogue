package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
    val divider: Color = Black800
)

val DetailColors = compositionLocalOf { DefaultDetailColors }