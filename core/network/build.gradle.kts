plugins {
    alias(libs.plugins.jetbrains.kotlin.android)  //kotlin
    alias(libs.plugins.ucb.android.library)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.example.network"
}

dependencies {
    implementation(libs.myretrofit)
    implementation(libs.moshi)
    implementation(libs.converter.moshi)
    kapt(libs.moshi.kapt)
}

kapt {
    correctErrorTypes = true
}