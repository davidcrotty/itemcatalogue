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

@Composable
fun CatalogueTemplateTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Black600
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