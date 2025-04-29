plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("maven-publish")
}

android {
    namespace = "com.example.finalprojecttcgtracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.finalprojecttcgtracker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.navigation.compose.v275)
    implementation(libs.androidx.navigation.compose)

    // Retrofit and Gson dependencies for API calls
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // For working with Room database
    implementation (libs.androidx.room.runtime)
    annotationProcessor (libs.androidx.room.compiler)  // Use kapt for Kotlin

    // Api
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Room runtime library
    implementation(libs.androidx.room.runtime)

    // If using Java source, use annotationProcessor
    annotationProcessor(libs.androidx.room.compiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // RxJava2 support for Room (optional)
    implementation(libs.androidx.room.rxjava2)

    // RxJava3 support for Room (optional)
    implementation(libs.androidx.room.rxjava3)

    // Guava support for Room (optional)
    implementation(libs.androidx.room.guava)

    // Test helpers for Room (optional)
    testImplementation(libs.androidx.room.testing)

    // Paging 3 Integration (optional)
    implementation(libs.androidx.room.paging)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}