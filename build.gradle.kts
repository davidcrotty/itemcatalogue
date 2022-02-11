buildscript {
    val compose_version by extra("1.1.0-rc03")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.0-beta02")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}