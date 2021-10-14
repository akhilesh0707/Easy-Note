import dependencies.*

plugins {
    id(Config.Plugins.androidApplication)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.daggerHiltAndroid)
}

android {
    compileSdk = Config.Android.compileSdk

    defaultConfig {
        minSdk = Config.Android.minSdk
        targetSdk = Config.Android.targetSdk
        applicationId = Environments.appId
        versionCode = Environments.Debug.appVersionCode
        versionName = Environments.Debug.appVersionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(Environments.Debug.name) {
            //applicationIdSuffix = Environments.Debug.suffix
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
        getByName(Environments.Release.name) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Modules
    implementation(project(Modules.core))
    implementation(project(Modules.featureNote))
    implementation(project(Modules.featureSettings))

    // AndroidX dependencies
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifeCycleKtx)
    implementation(AndroidX.material)

    // Compose dependencies
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.toolingPreview)
    implementation(Compose.materialIconExtended)
    implementation(Compose.activityCompose)
    implementation(Compose.navigationCompose)
    implementation(Compose.viewModelCompose)
    implementation(Compose.hiltNavigationCompose)

    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Dagger - Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltAndroidCompiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation(Room.roomKtx)
}