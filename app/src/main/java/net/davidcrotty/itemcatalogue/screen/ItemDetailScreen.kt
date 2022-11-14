package net.davidcrotty.itemcatalogue.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.molecule.DetailImage
import net.davidcrotty.itemcatalogue.ui.theme.Typography


@Preview
@Composable
fun ItemDetailScreen(
    url: String = "https://i0.wp.com/www.chaoticanwriter.com/chaoticanwriter.com/wp-content/uploads/2022/03/flamge-tongue-magic-items.jpg?fit=1000%2C1000&ssl=1",
    background: Color = MaterialTheme.colors.background) {
    Box(modifier = Modifier.background(background)) {
        Box {
            Box {
                ConstraintLayout {
                    val (detailImage, breadcrumbs, spacer, title) = createRefs()
                    DetailImage(modifier = Modifier.constrainAs(detailImage) {
                        top.linkTo(parent.top)
                    }, url)
                    Spacer(modifier = Modifier
                        .height(dimensionResource(id = R.dimen.padding_medium))
                        .constrainAs(spacer) {
                            top.linkTo(breadcrumbs.bottom)
                        })
                    Text("Title", style = Typography.h1.copy(
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
        }
    }
}