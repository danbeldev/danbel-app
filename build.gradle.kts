import org.jetbrains.compose.desktop.application.dsl.TargetFormat

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

kotlin {
    jvm("desktop")

    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.exampl.danbelapp"
            packageVersion = "1.0.0"
        }
    }
}


compose.experimental {
    web.application {}
}