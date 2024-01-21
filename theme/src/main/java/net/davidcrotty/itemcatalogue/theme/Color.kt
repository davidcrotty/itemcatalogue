package net.davidcrotty.itemcatalogue.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple500 = Color(0xFF9b7fed)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Blue800 = Color(0xFF8adeff)

val Green700 = Color(0xFF46df9b)

val Black600 = Color(0xFF202b33)
val Black800 = Color(0xFF10161A)

val White900 = Color(0xFFF5F3DC)
val White500 = Color(0xFFFBFBFC)

val Yellow300 = Color(0xFFE6BB2A)
val Yellow200 = Color(0xFFfacf57)
val Yellow100 = Color(0xFF9F9266)

val Grey500 = Color(0xFF48494b)
val Grey600 = Color(0xFF899ba7)
val Grey800 = Color(0xFFb3b3b3)

val Red500 = Color(0xFF9B4D43)
val Red600 = Color(0xFFCF6679)
val Red700 = Color(0xFFed454a)
val Red900 = Color(0xFFbc0f0e)

val Green400 = Color(0xFFd6d92b)

val LocalAppColours = compositionLocalOf { AppColours() }
@Immutable
class AppColours(
    val highlight: Color = Red900
)