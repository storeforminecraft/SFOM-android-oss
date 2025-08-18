plugins {
    alias(libs.plugins.sfom.android.library)
    alias(libs.plugins.sfom.android.library.compose)
}

android {
    namespace = "com.storeforminecraft.app.core.ui"
}

dependencies {
    api(projects.core.designsystem)

    implementation(libs.coil.compose)
}