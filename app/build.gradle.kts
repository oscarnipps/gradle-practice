plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.app.gradlepractice"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.app.gradlepractice"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

println("APP: This is executed during the configuration phase")

tasks.register("task1"){
    println("APP REGISTER TASK1: This is executed during the configuration phase")
}

tasks.register("task2"){
    println("APP REGISTER TASK2: This is executed during the configuration phase")
}

tasks.named("task1"){
    println("APP NAMED TASK1: This is executed during the configuration phase")
    doFirst {
        println("APP NAMED TASK1 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("APP NAMED TASK1 - doLast: This is executed during the execution phase")
    }
}


tasks.named("task2"){
    println("APP NAMED TASK2: This is executed during the configuration phase")
    doFirst {
        println("APP NAMED TASK2 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("APP NAMED TASK2 - doLast: This is executed during the execution phase")
    }
}