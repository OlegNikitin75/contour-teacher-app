import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)

}

android {
    namespace = "alex.dev.contourteacherapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "alex.dev.contourteacherapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val localProperties = Properties()
        val localPropertiesFile = project.rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localProperties.load(localPropertiesFile.inputStream())
        }
        buildConfigField(
            "String",
            "SUPABASE_KEY",
            "\"${localProperties.getProperty("SUPABASE_KEY", "")}\""
        )
        buildConfigField(
            "String",
            "SECRET",
            "\"${localProperties.getProperty("SECRET", "")}\""
        )
        buildConfigField(
            "String",
            "SUPABASE_URL",
            "\"${localProperties.getProperty("SUPABASE_URL", "")}\""
        )
        buildConfigField(
            "String",
            "WEB_CLIENT_ID",
            "\"${localProperties.getProperty("WEB_CLIENT_ID", "")}\""
        )
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
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget("11")
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    // 1. BOM в правильном порядке
    implementation(platform(libs.supabase.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.foundation)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    // 2. Android Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)

    // 3. Compose UI
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.constraintlayout.compose)

    // 4. Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // 5. Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    ksp(libs.kotlin.metadata.jvm)
    implementation(libs.androidx.hilt.navigation.compose)

    // 6. Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // 7. Supabase (версии управляются через BOM)
    implementation(libs.postgrest.kt)
    implementation(libs.auth.kt)
    implementation(libs.realtime.kt)
    implementation(libs.storage.kt)
    implementation(libs.functions.kt)

    implementation(libs.androidx.credentials)
    implementation(libs.googleid)

    // 8. ОБЯЗАТЕЛЬНО: Ktor Client для Android (нужен для Supabase)
    implementation(libs.ktor.client.android)

    // 9. Дополнительно для Supabase (рекомендуется):
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    // 10. Image Loading (Coil)
    implementation(libs.coil.compose)

    // 11. Тесты
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}