import groovy.lang.Closure
import org.gradle.api.artifacts.ExternalDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.closureOf
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.closureOf

object Utilities {

    fun implementation(library: String, options: ExternalDependency.() -> Unit = {}) =
        dependency(configuration = "implementation", library = library, options = closureOf(options))

    fun dependency(configuration: String, library: String, options: Closure<*>) =
        mapOf("configuration" to configuration, "dependency" to library, "options" to options)

    @JvmStatic
    fun addModules(handler: DependencyHandler, vararg modules: List<Map<String, Any>>) {
        modules.forEach { module ->
            module.forEach { item ->
                handler.add(
                    item["configuration"] as String,
                    item["dependency"] as String,
                    item["options"] as Closure<*>
                )
            }
        }
    }
}