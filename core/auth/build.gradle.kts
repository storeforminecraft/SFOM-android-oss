plugins {
    alias(libs.plugins.sfom.android.library)
    alias(libs.plugins.sfom.hilt)
}

android {
    namespace = "com.storeforminecraft.app.core.auth"
}

dependencies {
    implementation(projects.core.data)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
}