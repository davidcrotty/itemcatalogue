import groovy.lang.Closure
import org.gradle.api.artifacts.ExternalDependency
import Utilities.implementation

object Modules {
    val application = listOf(
        implementation(Libraries.splashScreen)
    )
}