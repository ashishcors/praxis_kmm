import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
  kotlin("multiplatform")
  id("com.android.library")
  id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
}

kotlin {
  android()
  ios {
    binaries {
      framework {
        baseName = "domainn"
      }
    }
  }
  sourceSets {
    val commonMain by getting{
      dependencies{
        api("dev.icerock.moko:parcelize:0.6.0")
      }
    }
    val androidMain by getting
    val iosMain by getting
  }
}

android {
  compileSdkVersion(ProjectProperties.COMPILE_SDK)
  defaultConfig {
    minSdkVersion(ProjectProperties.MIN_SDK)
    targetSdkVersion(ProjectProperties.TARGET_SDK)
  }
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

val packForXcode by tasks.creating(Sync::class) {
  group = "build"
  val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
  val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
  val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
  val framework =
    kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
  inputs.property("mode", mode)
  dependsOn(framework.linkTask)
  val targetDir = File(buildDir, "xcode-frameworks")
  from({ framework.outputDirectory })
  into(targetDir)
}
tasks.getByName("build")
    .dependsOn(packForXcode)