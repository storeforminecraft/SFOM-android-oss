plugins {
    alias(libs.plugins.sfom.android.library)
    alias(libs.plugins.sfom.android.library.compose)
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material3)
}