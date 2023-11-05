// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.parcelize).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    id("com.google.gms.google-services") version "4.4.0" apply false
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.sqldelight).apply(false)
}
true // Needed to make the Suppress annotation work for the plugins block