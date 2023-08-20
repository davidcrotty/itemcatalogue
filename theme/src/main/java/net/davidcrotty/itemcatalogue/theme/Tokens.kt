package net.davidcrotty.itemcatalogue.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class ItemCardToken(
    val itemTitle: TextStyle = TextStyle(
        fontSize = 18.sp,
        lineHeight = 22.4.sp,
        fontWeight = FontWeight(700),
        color = Color.White
    ),
    val itemSubtitle: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        fontWeight = FontWeight(700),
        color = Grey600
    ),
    val imageBorderColor: Color = Purple500,
    val imageBorderStroke: Dp = 1.dp,
    val itemPadding: Dp = Padding.medium,
    val itemHeight: Dp = 92.dp
)