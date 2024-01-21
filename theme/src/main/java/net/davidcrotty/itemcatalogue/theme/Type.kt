package net.davidcrotty.itemcatalogue.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// serif to pair with roboto sans-serif
val tiamat = FontFamily(
    Font(R.font.tiamat_light, FontWeight.Light),
    Font(R.font.tiamat_regular, FontWeight.Normal),
    Font(R.font.tiamat_medium, FontWeight.Medium)
)

val LocalFont = compositionLocalOf { AppBarToken() }

internal val screenTitleToken = TextStyle(
    fontSize = 16.sp,
    lineHeight = 22.4.sp,
    fontWeight = FontWeight(600),
    color = Color.White
)

internal val listItemTitleToken = TextStyle(
    fontSize = 18.sp,
    lineHeight = 22.4.sp,
    fontWeight = FontWeight(700),
    color = Color.White
)

internal val listItemSubheadingToken = TextStyle(
    fontSize = 14.sp,
    lineHeight = 16.8.sp,
    fontWeight = FontWeight(700),
    color = Grey600
)

internal val articleTitle = TextStyle(
    fontSize = 30.sp,
    lineHeight = 39.sp,
    fontWeight = FontWeight(700),
    color = Color.White,
    fontFamily = FontFamily(Font(DeviceFontFamilyName("sans-serif-condensed")))
)

internal val articleBody = TextStyle(
    fontSize = 14.sp,
    color = Color.White
)

internal val spellType: SpanStyle = SpanStyle(
    fontFamily = tiamat,
    fontWeight = FontWeight.ExtraLight,
    fontSize = 16.sp,
    color = Black800,
    fontFeatureSettings = "c2sc, smcp",
)