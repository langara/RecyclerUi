plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Vers.androidCompileSdk)
    defaultConfig {
        applicationId = "pl.mareklangiewicz.recyclerui"
        minSdkVersion(21)
        targetSdkVersion(Vers.androidTargetSdk)
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":recyclerui"))
    implementation(Deps.splitties)
}
