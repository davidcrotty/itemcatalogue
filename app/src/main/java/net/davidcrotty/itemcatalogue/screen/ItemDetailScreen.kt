package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.atom.BackgroundImage
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.organism.StatTable
import net.davidcrotty.itemcatalogue.ui.theme.TableTheme
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
                    val (detailImage, breadcrumbs, spacer, title, subtitle) = createRefs()
                    DetailImage(modifier = Modifier.height(100.dp).constrainAs(detailImage) {
                        top.linkTo(parent.top)
                    })
                    Spacer(modifier = Modifier
                        .height(dimensionResource(id = R.dimen.padding_medium))
                        .constrainAs(spacer) {
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
                        top.linkTo(detailImage.bottom)
                    })
                }
            }
            Column {
                Spacer(modifier = Modifier.height(
                    with(LocalDensity.current) {
                        sizeImage.height.toDp()
                    }
                ))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text("Proficiency with a battleaxe allows you to add your proficiency bonus to the attack roll for any attack you make with it",
                    style = Typography.subtitle2,
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.45).dp))
                Spacer(modifier = Modifier.height(
                    with(LocalDensity.current) {
                        (sizeImage.height * 0.25).toInt().toDp()
                    }
                ))
                TableTheme {
                    StatTable()
                }
            }
        }
    }
}