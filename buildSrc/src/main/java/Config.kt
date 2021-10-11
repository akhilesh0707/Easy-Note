object Config {

    object Android {
        // Android sdk and version
        const val compileSdk = 31
        const val minSdk = 21
        const val targetSdk = 31
    }

    object ClassPath {
        const val gradleBuildTools = "com.android.tools.build:gradle:${Versions.gradleBuildVersion}"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val hiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHiltVersion}"
    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val daggerHiltAndroid = "dagger.hilt.android.plugin"
    }

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

}