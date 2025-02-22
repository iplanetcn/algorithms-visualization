plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    application
}

group = "com.phenix"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("AppKt")
}