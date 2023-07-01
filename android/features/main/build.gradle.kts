plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.compose")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Android.Module.Features.nameSpace + ".main"

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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(Shared.module))
    implementation(project(Android.Module.Features.common))

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.android.compose)
    kapt(libs.hilt.android.compiler)

    // Timber
    implementation(libs.jakewharton.timber)

    // activity - compose
    implementation(libs.androidx.activity.compose)

    // compose
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.icon.extended)

    // compose preview
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // test
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.android.espresso.core)
}