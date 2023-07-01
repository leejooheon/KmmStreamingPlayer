plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.compose")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Android.Module.Features.nameSpace + ".common"

    compileSdk = Android.Versions.compileSdk
    defaultConfig {
        minSdk = Android.Versions.minSdk
        targetSdk = Android.Versions.targetSdk
    }
    compileOptions {
        sourceCompatibility = Android.Versions.javaCompileVersion
        targetCompatibility = Android.Versions.javaCompileVersion
    }
    kotlinOptions {
        jvmTarget = Android.Versions.javaLanguageVersion
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
dependencies {
    // compose
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)

    // android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // coroutine
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)

    // accompanist
    implementation(libs.google.accompanist.navigation.material)
}