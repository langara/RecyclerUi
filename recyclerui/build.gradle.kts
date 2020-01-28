plugins {
    id("com.android.library")
    kotlin("android")
}
group = "com.github.langara.recyclerui"
version = "0.0.1"

android {
    compileSdkVersion(Vers.androidCompileSdk)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(Vers.androidTargetSdk)
        versionCode = 100
        versionName = "0.0.1"
    }
}

dependencies {
    implementation(Deps.kotlinStdlib7)
    implementation(Deps.splitties)
}

apply(from = "https://raw.githubusercontent.com/sky-uk/gradle-maven-plugin/master/gradle-mavenizer.gradle")
