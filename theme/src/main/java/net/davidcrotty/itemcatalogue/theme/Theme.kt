package net.davidcrotty.itemcatalogue.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val LocalCatalogTemplateValues = compositionLocalOf { DefaultCatalogueTemplateValues }

val DefaultCatalogueTemplateValues = CatalogTemplateValues()

class CatalogTemplateValues(
    val itemCardToken: ItemCardToken = ItemCardToken(),
    val itemDetailToken: ItemDetailToken = ItemDetailToken(),
    val backgroundToken: BackgroundColourToken = BackgroundColourToken()
)

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

    val localValues = CornerRadiusSizes()
    val localCatalogTemplateValues = CatalogTemplateValues()

    CompositionLocalProvider(
        LocalValues provides localValues,
        LocalCatalogTemplateValues provides localCatalogTemplateValues
    ) {
        MaterialTheme(
            colors = colors,
            shapes = Shapes,
            content = content
        )
    }
}