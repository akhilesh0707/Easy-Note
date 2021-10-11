import dependencies.*

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.daggerHiltAndroid)
}

android {
    compileSdk = Config.Android.compileSdk

    defaultConfig {
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        useIR = true
    }
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

    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Room
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    // Kotlin Extensions and Coroutines support for Room
    implementation(Room.roomKtx)
}