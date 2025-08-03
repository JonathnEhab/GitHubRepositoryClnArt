plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.presentation"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.compose.material3:material3:1.1.2")

    // mockk
    testImplementation("io.mockk:mockk:1.13.3")
    // turbine
    testImplementation("app.cash.turbine:turbine:0.7.0")
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // compose
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.material:material:1.5.4")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation (platform("androidx.compose:compose-bom:2024.05.00")) // أو أحدث إصدار
    implementation ("androidx.compose.material:material")

    implementation("androidx.navigation:navigation-compose:2.7.5")

    // test compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Dagger - Hilt
    val dagger_hilt= "2.48"
    implementation("com.google.dagger:hilt-android:$dagger_hilt")
    kapt("com.google.dagger:hilt-compiler:$dagger_hilt")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    // paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")

    // lottie
    implementation("com.airbnb.android:lottie-compose:6.0.0")

    implementation(project(":domain"))

    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")

    implementation("xmlpull:xmlpull:1.1.3.1")
}
