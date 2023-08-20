package net.davidcrotty.itemcatalogue.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class ItemCardToken(
    val itemTitle: TextStyle = TextStyle(
        fontSize = 18.sp,
        lineHeight = 22.4.sp,
        fontWeight = FontWeight(700),
        color = Color.White
    )
)