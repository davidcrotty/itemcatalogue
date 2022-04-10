dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots")
        }
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "My Application"
include(":app")
include(":listfeature")
include(":domain")
include(":domain:items")
