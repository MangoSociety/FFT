@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    id("com.google.gms.google-services")
//    alias(libs.plugins.jetbrains.compose)
}

android {
    namespace = "com.mangosociety.friendlychallengetime"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mangosociety.friendlychallengetime"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":shared"))

    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui.tooling)
    implementation(libs.material3)
    implementation("androidx.compose.material:material:1.5.4")
    implementation(libs.ui)
//    implementation(libs.m)

    // Decompose Libraries
    api(libs.decompose.decompose)
    api(libs.essenty.lifecycle)
    implementation(libs.decompose.extensionsComposeJetbrains)

    // CameraX
    val camerax_version = "1.0.1"
    implementation ("androidx.camera:camera-camera2:$camerax_version")
    implementation ("androidx.camera:camera-lifecycle:$camerax_version")
    implementation ("androidx.camera:camera-view:1.0.0-alpha27")

// Icons
    implementation ("androidx.compose.material:material-icons-extended:1.5.1")

    implementation ("io.coil-kt:coil-compose:1.4.0")

    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-analytics")

}