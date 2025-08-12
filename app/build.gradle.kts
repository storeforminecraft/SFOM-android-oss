plugins {
    alias(libs.plugins.sfom.android.application)
    alias(libs.plugins.sfom.android.application.compose)
}

android {
    namespace = "com.storeforminecraft.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.newidea.mcpestore"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)

    implementation(projects.core.designsystem)
}