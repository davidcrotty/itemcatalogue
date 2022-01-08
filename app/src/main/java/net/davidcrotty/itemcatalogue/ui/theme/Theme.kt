package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

val ListItemTheme = staticCompositionLocalOf {
    ListItemColors(
        content = Color.Unspecified
    )
}

@Immutable // annotation provides compiler optimisations
data class ListItemColors(
    val content: Color
)

// TODO red colour not showing on text when compiling
@Composable
fun ListItemTheme(
    content: @Composable () -> Unit
) {
    val customColors = ListItemColors(
        content = Color.Red
    )

    CompositionLocalProvider(
        ListItemTheme provides customColors,
        content = content
    )
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