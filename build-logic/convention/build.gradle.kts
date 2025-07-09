plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.sfom.android.application.asProvider().get().pluginId
            implementationClass = "com.storeforminecraft.app.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = libs.plugins.sfom.android.application.compose.get().pluginId
            implementationClass = "com.storeforminecraft.app.buildlogic.AndroidApplicationComposeConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.sfom.hilt.get().pluginId
            implementationClass = "com.storeforminecraft.app.buildlogic.HiltConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.sfom.android.library.get().pluginId
            implementationClass = "com.storeforminecraft.app.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.sfom.android.feature.get().pluginId
            implementationClass = "com.storeforminecraft.app.buildlogic.AndroidFeatureConventionPlugin"
        }
    }
}