package net.davidcrotty.itemcatalogue.theme

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

private val DarkColorPalette = darkColors(
    primary = Red600,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Black800
)

@Deprecated("Not used currently, was used as an example of custom theming", replaceWith = ReplaceWith("CatalogueTemplateTheme"))
@Composable
fun ListItemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

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
    val colors = DarkColorPalette

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
    val colors = DarkColorPalette

    val tableColors = TableColors()
    val appTypography = ItemTypography()

    CompositionLocalProvider(
        LocalColors provides tableColors,
        LocalFont provides appTypography
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}