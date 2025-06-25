plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // kotlin kapt
    kotlin("kapt")
    // dagger hilt plugin
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.example.mvvmexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mvvmexample"
        minSdk = 24
        targetSdk = 35
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    //viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //life data
    implementation(libs.androidx.lifecycle.livedata)
    //fragments
    implementation(libs.androidx.fragment.ktx)
    //activity
    implementation(libs.androidx.activity.ktx)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //coroutines
    implementation(libs.kotlinx.coroutines.android)
    //dagger hilt y kapt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

