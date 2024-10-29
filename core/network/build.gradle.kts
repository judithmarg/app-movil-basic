plugins {
    alias(libs.plugins.jetbrains.kotlin.android)  //kotlin
    alias(libs.plugins.ucb.android.library)
    //alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.network"
}

dependencies {
    implementation(libs.myretrofit)
    implementation(libs.moshi)
    implementation(libs.converter.moshi)
    implementation(project(":core:data"))
    //kapt(libs.moshi.kapt)
    implementation(project(":core:model"))
    ksp(libs.moshi.kapt)
}

//kapt {
//    correctErrorTypes = true
//}