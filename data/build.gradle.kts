plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.data"
    compileSdk = 36

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
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // mockk
    testImplementation("io.mockk:mockk:1.13.3")
    testImplementation("app.cash.turbine:turbine:0.7.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // okhttp3
    testImplementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")

    // gson for serialized name annotation
    implementation("com.google.code.gson:gson:2.10")

    // ROOM
    annotationProcessor("androidx.room:room-compiler:2.6.0")
    // To use Kotlin annotation processing tool (kapt)
    ksp("androidx.room:room-compiler:2.6.0")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.6.0")

    // paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.room:room-paging:2.6.0")
    implementation("androidx.paging:paging-compose:3.2.1")
    // Data Store
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("androidx.profileinstaller:profileinstaller:1.3.1")
    implementation(project(":domain"))
}