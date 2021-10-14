import dependencies.AndroidX
import dependencies.Compose
import dependencies.DaggerHilt

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.daggerHiltAndroid)
}

android {
    compileSdk = Config.Android.compileSdk

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
}

dependencies {
    // Modules
    implementation(project(Modules.core))

    // AndroidX dependencies
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.material)

    // Compose dependencies
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.materialIconExtended)
    implementation(Compose.viewModelCompose)
    implementation(Compose.hiltNavigationCompose)

    // Dagger - Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltAndroidCompiler)
}