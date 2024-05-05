pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        kotlin("multiplatform").version(kotlinVersion)

        val composeVersion = extra["compose.version"] as String
        id("org.jetbrains.compose").version(composeVersion)
    }
}

rootProject.name = "DanBelApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
