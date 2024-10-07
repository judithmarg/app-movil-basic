plugins {
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ucb.android.library)
    alias(libs.plugins.ksp)
}

android{
    namespace = "com.example.data"
}

dependencies{
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)

    //optional - kotlin extensions and coroutines support for room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.rxjava2)
    implementation(libs.androidx.room.rxjava3)
    implementation(libs.androidx.room.guava)
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.paging)
}
