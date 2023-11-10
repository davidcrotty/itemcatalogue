import groovy.lang.Closure
import org.gradle.api.artifacts.ExternalDependency
import Utilities.implementation
import Utilities.platform

object Modules {
    val application = listOf(
        implementation(Libraries.splashScreen),
        implementation(Libraries.retrofit),
        implementation(Libraries.retrofitMoshiConverter),
        implementation(Libraries.moshi),
        implementation(Libraries.moshiKotlin),
        platform(Libraries.compose),
        implementation(Libraries.composeUi),
        implementation(Libraries.composeMaterial),
        implementation(Libraries.composeAnimation),
        implementation(Libraries.composeTooling)
    )

    val data = listOf(
        implementation(Libraries.retrofit),
        implementation(Libraries.retrofitMoshiConverter),
        implementation(Libraries.moshi),
        implementation(Libraries.moshiKotlin)
    )

    val detail = listOf(
        platform(Libraries.compose),
        implementation(Libraries.composeUi),
        implementation(Libraries.composeMaterial),
        implementation(Libraries.composeAnimation),
        implementation(Libraries.composeTooling)
    )

    val androidCommon = listOf(
        implementation(Libraries.androidCore)
    )
}