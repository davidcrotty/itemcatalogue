dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots")
        }
        maven {
            url = java.net.URI("https://jitpack.io")
        }
        google()
        mavenCentral()
    }
}
rootProject.name = "My Application"
include(":app")
include(":domain")
include(":domain:items")
include(":data")
include(":theme")
include(":feature:detailscreen")
include(":core:unittest")
include(":feature:listscreen")
