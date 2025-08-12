plugins {
    alias(libs.plugins.sfom.android.library)
    alias(libs.plugins.sfom.hilt)
}

android {
    namespace = "com.storeforminecraft.app.core.firestore"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
}