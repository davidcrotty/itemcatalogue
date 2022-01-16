package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// TODO KMM exposing this as an accessable website for designers is a great idea
private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Immutable
data class CustomColors(
    val content: Color,
    val component: Color,
    val background: List<Color>,
    val surface: Color,
    val color: Color
)

@Immutable
data class CustomTypography(
    val body: TextStyle,
    val title: TextStyle
)

@Immutable
data class CustomElevation(
    val default: Dp,
    val pressed: Dp
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        content = Color.Unspecified,
        component = Color.Unspecified,
        background = emptyList(),
        surface = Color.Unspecified,
        color = Color.Unspecified
    )
}
val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}
val LocalCustomElevation = staticCompositionLocalOf {
    CustomElevation(
        default = Dp.Unspecified,
        pressed = Dp.Unspecified
    )
}


@Deprecated("Not used currently, was used as an example of custom theming", replaceWith = ReplaceWith("CatalogueTemplateTheme"))
@Composable
fun ListItemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val customThemeColors = colors.copy(
        surface = Color.Red
    )

    val customColors = CustomColors(
        content = Color(0xFFDD0D3C),
        component = Color(0xFFC20029),
        background = listOf(Color.White, Color(0xFFF8BBD0)),
        surface = Color.Red,
        color = Color.Blue
    )
    val customTypography = CustomTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 32.sp)
    )
    val customElevation = CustomElevation(
        default = 4.dp,
        pressed = 8.dp
    )
    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        LocalCustomElevation provides customElevation
    ) {
        MaterialTheme(
            content = content,
            colors = customThemeColors
        )
    }
}

@Composable
fun CatalogueTemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Black800(context),
            darkIcons = !darkTheme
        )
    }

    // This is good for a basic default for a simple / prototype app
    // but real world scenarios will have the demand for custom components with ambients
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}