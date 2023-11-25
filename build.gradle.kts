val logback_version: String by project
val kotest_version: String by project

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("io.ktor.plugin") version "2.3.6"
}

allprojects {
    group = "com.bandsum"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("base")
        plugin("kotlin")
        plugin("kotlinx-serialization")
    }

    dependencies {
        implementation("ch.qos.logback:logback-classic:$logback_version")

        testImplementation("io.kotest:kotest-runner-junit5:$kotest_version")
        testImplementation("io.kotest:kotest-assertions-core:$kotest_version")

    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

