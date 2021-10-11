import dependencies.AndroidX
import dependencies.Compose

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
}

android {
    compileSdk = Config.Android.compileSdk
}

dependencies {
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
}