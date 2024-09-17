plugins {
    alias(libs.plugins.jetbrains.kotlin.android)  //kotlin
    alias(libs.plugins.ucb.android.library)
}

android {
    namespace = "com.example.ui"
}

dependencies {
    implementation(libs.myretrofit)
    //implementation(libs.converter.moshi)
}