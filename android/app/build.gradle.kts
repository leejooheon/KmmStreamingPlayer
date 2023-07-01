plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Android.nameSpace
    compileSdk = Android.Versions.compileSdk

    defaultConfig {
        applicationId = Shared.applicationId

        minSdk = Android.Versions.minSdk
        targetSdk = Android.Versions.targetSdk

        versionCode = Android.Releases.versionCode
        versionName = Android.Releases.versionName
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
    compileOptions {
        sourceCompatibility = Android.Versions.javaCompileVersion
        targetCompatibility = Android.Versions.javaCompileVersion
    }
    kotlinOptions {
        jvmTarget = Android.Versions.javaLanguageVersion
    }
}

dependencies {
    implementation(project(Shared.module))
    implementation(project(Android.Module.data))
    implementation(project(Android.Module.Features.main))

    // hilt
    implementation(libs.hilt.android)
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