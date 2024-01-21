package net.davidcrotty.itemcatalogue.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// serif to pair with roboto sans-serif
val tiamat = FontFamily(
    Font(R.font.tiamat_light, FontWeight.Light),
    Font(R.font.tiamat_regular, FontWeight.Normal),
    Font(R.font.tiamat_medium, FontWeight.Medium)
)

val roboto = FontFamily(
    Font(R.font.roboto_light, FontWeight.Light)
)

val mrseaves = FontFamily(
    Font(R.font.mrseave_regular, FontWeight.Normal),
    Font(R.font.mrseave_bold, FontWeight.Bold)
)

val LocalFont = compositionLocalOf { ItemTypography() }
@Immutable
class ItemTypography(
    val screenTitle: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
        fontWeight = FontWeight(600),
        color = Color.White
    )
)