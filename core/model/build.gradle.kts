plugins {
    alias(libs.plugins.jetbrains.kotlin.android)  //kotlin
    alias(libs.plugins.ucb.android.library)
    alias(libs.plugins.ucb.jvm.library)
}

android {
    namespace = "com.example.model"
}