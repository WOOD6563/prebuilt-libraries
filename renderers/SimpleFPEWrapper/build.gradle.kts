plugins {
    id("com.android.library")
}

android {
    namespace = "top.mobilegl.simplefpewrapper"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

        ndkVersion = "27.3.13750724"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        create("proguard") {
            isMinifyEnabled = true
            initWith(getByName("debug"))
        }
        create("fordebug") {
        }
    }

    sourceSets {
        getByName("main") {
            assets.srcDirs("assets")
        }
    }

    externalNativeBuild {
        cmake {
            path = file("SimpleFPEWrapper/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
