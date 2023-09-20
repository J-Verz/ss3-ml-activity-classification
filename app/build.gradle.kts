plugins {
    id("com.android.application")
}

android {
    namespace = "nl.utwente.ss.ss2mlactivitydetectiontest"
    compileSdk = 33

    defaultConfig {
        applicationId = "nl.utwente.ss.ss2mlactivitydetectiontest"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    configurations {
        all {
            exclude("com.github.vbmacher","java-cup")
            exclude("com.github.vbmacher","java-cup-runtime")
            exclude("jakata.activation", "jakarta.activation-api")
            exclude("com.sun.activation", "jakarta.activation")
        }
    }

    packagingOptions {
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/NOTICE.md")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs/wekaSTRIPPED.jar")) //https://github.com/rjmarsan/Weka-for-Android
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}