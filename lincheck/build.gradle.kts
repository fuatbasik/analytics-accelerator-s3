import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.10"
    java
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(libs.s3)
    testImplementation("org.jetbrains.kotlinx:lincheck:2.34")
    testImplementation("software.amazon.s3.analyticsaccelerator:analyticsaccelerator-s3:1.0.0")

//    testImplementation(project(":input-stream"))
//    testImplementation(project(":common"))
//    testImplementation(project(":object-client"))
    testImplementation(libs.junit.jupiter)


}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Replace 17 with your desired Java version
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17) // for Java 17
    }
}
