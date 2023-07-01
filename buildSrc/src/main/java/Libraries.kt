import org.gradle.api.JavaVersion

object Shared {
    const val applicationId = "com.jooheon.kmmstreamingplayer"
    const val nameSpace = "com.jooheon.kmmstreamingplayer"

    const val name = "shared"
    const val module = ":shared"

}

object Android {
    const val nameSpace = Shared.applicationId + ".android"

    object Releases {
        const val versionCode = 10000
        const val versionName = "01.00.00"
    }

    object Versions {
        const val compileSdk = 33
        const val targetSdk = 33
        const val minSdk = 24

        const val javaLanguageVersion = "17"
        val javaCompileVersion = JavaVersion.VERSION_17
    }

    object Module {
        const val data = ":android:data"

        object Features {
            const val nameSpace = Android.nameSpace + ".features"

            const val common = ":android:features:common"
            const val main = ":android:features:main"
        }
    }
}

object Ios {

}