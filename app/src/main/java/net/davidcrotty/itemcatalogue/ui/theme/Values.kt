package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

class CornerRadius(val value: Float)

val DefaultCornerRadiusSizes = CornerRadiusSizes()

@Immutable
class CornerRadiusSizes(
    val large: CornerRadius = CornerRadius(32.dp.value)
)

val LocalValues = compositionLocalOf { DefaultCornerRadiusSizes }