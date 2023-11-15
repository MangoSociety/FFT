plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.jetbrains.compose)
    id("com.google.gms.google-services")
    alias(libs.plugins.sqldelight)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
//    targetHierarchy.default()

    android()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
//    listOf(
//        ios()
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//        }
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                with(compose) {
                    api(runtime)
                    api(foundation)
                    api(material)
                    api(material3)
                    api(materialIconsExtended)
                }

                implementation(libs.ui.tooling)
                implementation(libs.ui.tooling.preview)

                api(libs.koin.core)
                api(libs.koin.android)

                implementation(libs.coroutine.core)
//                implementation(libs.kotlin.serialization)

                api(libs.arkivanov.mvikotlin)
                api(libs.arkivanov.mvikotlin.main)
                api(libs.arkivanov.mvikotlin.ext.coroutine)

                api(libs.decompose.decompose)
                api(libs.decompose.extensionsComposeJetbrains)
                implementation(libs.essenty.lifecycle)

                implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
                implementation("com.google.firebase:firebase-firestore")

                api(libs.sqldelight.coroutine.ext)
                api(libs.sqldelight.primitive.adapter)
            }
        }
        val commonTest by getting {
            dependencies {}
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.android)
            }
        }
    }
}

android {
    namespace = "com.mangosociety.friendlychallengetime.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

sqldelight {
    databases {
        create("FFTDatabase") {
            packageName.set("com.mangosociety.friendlychallengetime.shared.commonMain")
        }
    }
}
