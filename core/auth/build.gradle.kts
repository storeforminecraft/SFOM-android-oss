plugins {
    alias(libs.plugins.sfom.android.library)
}

android {
    namespace = "com.storeforminecraft.app.core.auth"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
}