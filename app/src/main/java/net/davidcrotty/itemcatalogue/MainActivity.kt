package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppContainer
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

    private val dndContainer by lazy { applicationContext.applicationContext as DndCatalogueAppContainer }

    @OptIn(ExperimentalAnimationGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val controller = rememberNavController()
            val navigator = NavigatorImpl(controller)
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .fillMaxWidth()
//            ) {
//                val image = AnimatedImageVector.animatedVectorResource(R.drawable.sword)
//                val atEnd by remember { mutableStateOf(false) }
//                Icon(
//                    painter = rememberAnimatedVectorPainter(image, atEnd),
//                    contentDescription = null // decorative element
//                )
//            }
//            ComposeWrapper(
//                controller, dndContainer.itemScreenGraph()
//            ) {
//                navigator.navigate(it)
//            }
        }
    }
}