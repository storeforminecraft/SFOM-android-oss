package com.storeforminecraft.app.buildlogic

import com.storeforminecraft.app.buildlogic.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "sfom.android.library")
            apply(plugin = "sfom.hilt")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                "implementation"(project(":core:designsystem"))
                "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
                "implementation"(libs.findLibrary("androidx.navigation.compose").get())
            }
        }
    }
}