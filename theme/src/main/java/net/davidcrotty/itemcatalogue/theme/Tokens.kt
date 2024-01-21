package net.davidcrotty.itemcatalogue.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class ItemCardToken(
    val itemTitle: TextStyle = listItemTitleToken,
    val itemSubtitle: TextStyle = listItemSubheadingToken,
    val defaultImageBorderColor: Color = Purple500,
    val imageBorderStroke: Dp = 1.dp,
    val itemPadding: Dp = Padding.medium,
    val itemHeight: Dp = 92.dp,
    val borderColours: Map<String, Color> = elementMapToken
)

class ItemDetailToken(
    val detailTitle: TextStyle = articleTitle,
    val detailBody: TextStyle = articleBody,
    val dividerColour: Map<String, Color> = elementMapToken,
    val defaultDividerColor: Color = Purple500,
    val noImageTint: Color = White900
)

@Immutable
class AppBarToken(
    val screenTitle: TextStyle = screenTitleToken
)

class BackgroundColourToken(val color: Color = Black800)

private val elementMapToken: Map<String, Color> = mutableMapOf<String, Color>().apply {
    put("acid", Green400)
    put("radiant", Yellow200)
    put("necrotic", Green700)
    put("force", Red700)
    put("cold", Blue800)
    put("fire", Orange800)
    put("poison", Green800)
    put("lightning", Blue900)
    put("heal", Teal300)
    put("psychic", Purple500)
}