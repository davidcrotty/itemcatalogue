package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.BackgroundImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography



@Composable
fun ItemDetailScreen(url: String = "https://cutewallpaper.org/21/dungeon-master-wallpaper/Dungeon-Masters-Guide-Dungeons-and-Dragons.jpg") {
    Box {
        var sizeImage by remember { mutableStateOf(IntSize.Zero) }
        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Transparent, MaterialTheme.colors.background),
            startY = sizeImage.height.toFloat() / 3,
            endY = sizeImage.height.toFloat()
        )
        BackgroundImage(url, gradient) { size ->
            sizeImage = size
        }
        Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Box {
                ConstraintLayout {
                    val (breadcrumbs, spacer, title) = createRefs()
                    Text("Items > Weapons", style = Typography.caption, modifier = Modifier.constrainAs(breadcrumbs) {
                        top.linkTo(parent.top)
                    }) // TODO write bread crumbs function/widget
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)).constrainAs(spacer) {
                        top.linkTo(breadcrumbs.bottom)
                    })
                    Text("Battleaxe", style = Typography.h1.copy(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(spacer.bottom)
                    })
                }
//                    Text("Damage Combat", style = Typography.subtitle1.copy(
//                        shadow = Shadow(
//                            color = Color.Black,
//                            offset = Offset(4f, 4f),
//                            blurRadius = 8f
//                        )
//                    ))
            }
            Column {
                Spacer(modifier = Modifier.height(
                    with(LocalDensity.current) {
                        sizeImage.height.toDp()
                    }
                ))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text(LoremIpsum().values.reduce { prev, current -> "$prev $current" }, style = Typography.subtitle2)
            }
        }
    }
}