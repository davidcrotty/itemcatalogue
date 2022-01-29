package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.davidcrotty.itemcatalogue.R

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
    Font(R.font.mrseave_regular, FontWeight.Normal)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Grey500
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Grey800
    ),
    h1 = TextStyle(
        fontFamily = mrseaves,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        color = White500
    ),
    h2 = TextStyle(
        fontFamily = tiamat,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        color = Grey500
    ),
    caption = TextStyle(
        fontFamily = roboto,
        fontSize = 14.sp,
        color = White500,
        fontWeight = FontWeight.Light,
        fontFeatureSettings = "c2sc, smcp" // compose does not have all caps functionality yet in styles, sets font feature directly
    )
)