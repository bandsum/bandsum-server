val ktor_version: String by project

plugins {
    id("io.ktor.plugin")
}

dependencies {
    api(project(":libs"))
    api(project(":domain"))
    api(project(":data"))

    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-resources")

    testImplementation("io.ktor:ktor-server-tests-jvm")
}

application {
    mainClass.set("com.bandsum.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
