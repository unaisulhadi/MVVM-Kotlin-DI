object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}


object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val activityKtx by lazy { "androidx.activity:activity-ktx:${Versions.activityKtx}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val coil by lazy { "io.coil-kt:coil:${Versions.coil}" }


    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }
    val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}" }
    val hiltViewModelAp by lazy { "androidx.hilt:hilt-compiler:${Versions.daggerLifecycle}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val okhttpInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"}
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"}

    val lifecycleExtensions by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }


    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.sizing}" }
    val ssp by lazy { "com.intuit.ssp:ssp-android:${Versions.sizing}" }


    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.jUnitExtTest}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }

}
