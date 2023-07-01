plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Android.nameSpace + ".data"

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
    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(path = Shared.module))

    // coroutine
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}