plugins {
    alias(libs.plugins.sfom.android.feature)
    alias(libs.plugins.sfom.android.library.compose)
}

android {
    namespace = "com.storeforminecraft.app.feature.auth"
}

dependencies {
    implementation(projects.core.data)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
}