plugins {
    alias(libs.plugins.sfom.android.feature)
    alias(libs.plugins.sfom.android.library.compose)
}

android {
    namespace = "com.storeforminecraft.app.feature.studio"
}

dependencies {
    api(projects.core.common)

    implementation(projects.core.data)
}