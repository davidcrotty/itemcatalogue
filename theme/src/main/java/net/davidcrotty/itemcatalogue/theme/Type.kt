package net.davidcrotty.itemcatalogue.theme

import androidx.compose.material.Typography
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

val TableTypography = Typography(
    h1 = TextStyle(
        fontFamily = mrseaves,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Red500
    ),
    subtitle1 = TextStyle(
        fontFamily = mrseaves,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Red500
    ),
    body1 = TextStyle(
        fontFamily = mrseaves,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Red500
    )
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
    subtitle1 = TextStyle(
        fontFamily = roboto,
        fontSize = 16.sp,
        color = Yellow300,
        fontWeight = FontWeight.Light,
        fontFeatureSettings = "c2sc, smcp" // compose does not have all caps functionality yet in styles, sets font feature directly
    ),
    subtitle2 = TextStyle(
        fontFamily = roboto,
        fontSize = 14.sp,
        color = Yellow100,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    ), // TODO looks like smaller subthemes depending on component, redothis
    caption = TextStyle(
        fontFamily = roboto,
        fontSize = 14.sp,
        color = White500,
        fontWeight = FontWeight.Light,
        fontFeatureSettings = "c2sc, smcp" // compose does not have all caps functionality yet in styles, sets font feature directly
    )
)