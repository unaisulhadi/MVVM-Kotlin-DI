plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.hadi.mvvmplayground"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(Deps.coreKtx)
    implementation(Deps.activityKtx)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    implementation(Deps.timber)
    implementation(Deps.coil)
    implementation(Deps.ssp)
    implementation(Deps.sdp)


    //Retrofit
    implementation(Deps.retrofit)
    implementation(Deps.okhttpInterceptor)
    implementation(Deps.converterGson)
    implementation(Deps.gson)

    //Coroutines
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)

    //Lifecycle
    implementation(Deps.lifecycleExtensions)
    implementation(Deps.lifecycleRuntime)
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.lifecycleLiveData)

    //Hilt
    implementation(Deps.hiltAndroid)
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltViewModel)
    kapt(Deps.hiltViewModelAp)

    //Test
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espressoCore)
}