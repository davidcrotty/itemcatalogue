package net.davidcrotty.itemcatalogue.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import net.davidcrotty.itemcatalogue.theme.Black800
import net.davidcrotty.itemcatalogue.theme.CornerRadiusSizes
import net.davidcrotty.itemcatalogue.theme.Grey900
import net.davidcrotty.itemcatalogue.theme.LocalColors
import net.davidcrotty.itemcatalogue.theme.LocalValues
import net.davidcrotty.itemcatalogue.theme.Purple700
import net.davidcrotty.itemcatalogue.theme.Red600
import net.davidcrotty.itemcatalogue.theme.Red800
import net.davidcrotty.itemcatalogue.theme.Shapes
import net.davidcrotty.itemcatalogue.theme.TableColors
import net.davidcrotty.itemcatalogue.theme.Teal200
import net.davidcrotty.itemcatalogue.theme.Typography
import net.davidcrotty.itemcatalogue.theme.White100
import net.davidcrotty.itemcatalogue.theme.White300

private val DarkColorPalette = darkColors(
    primary = Red600,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Red800,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = White300,
    background = White100,
    onSurface = Grey900,
)

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
    CompositionLocalProvider{
        MaterialTheme(
            content = content,
            colors = customThemeColors
        )
    }
}

@Composable
fun CatalogueTemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
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

    val values = CornerRadiusSizes() // TODO wrap as this becomes more complex

    CompositionLocalProvider(
        LocalValues provides values
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

@Composable
fun TableTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val tableColors = TableColors()

    CompositionLocalProvider(
        LocalColors provides tableColors
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}