plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    kotlin("kapt")
}

android {
    namespace = "dev.johny.gith"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.johny.gith"
        minSdk = 26
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(project(":empty_feature_api"))
    implementation(project(":empty_feature"))

    implementation(project(":second_feature_api"))
    implementation(project(":second_feature"))

    implementation(project(":core_network"))
    implementation(project(":core_network_api"))

    // Dagger 2
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)

    // Tests
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotest.extensions.mockserver)
}