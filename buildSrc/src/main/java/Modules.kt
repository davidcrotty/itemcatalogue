import groovy.lang.Closure
import org.gradle.api.artifacts.ExternalDependency
import Utilities.implementation
import Utilities.testImplementation
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
        implementation(Libraries.composeTooling),
        implementation(Libraries.appCompat),
        implementation(Libraries.material),
        implementation(Libraries.lifecycle),
        implementation(Libraries.activityCompose),
        implementation(Libraries.navigationCompose),
        implementation(Libraries.coil)
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
        implementation(Libraries.composeTooling),
        implementation(Libraries.appCompat),
        implementation(Libraries.material),
        implementation(Libraries.viewModel),
        implementation(Libraries.constraintCompose),
        implementation(Libraries.coil)
    )

    val androidCommon = listOf(
        implementation(Libraries.androidCore)
    )

    val unitTest = listOf(
        testImplementation(Libraries.jUnitJupiterEngine),
        testImplementation(Libraries.mockK),
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"),
        testImplementation("com.github.xgouchet.Elmyr:core:1.3.1")
    )
}