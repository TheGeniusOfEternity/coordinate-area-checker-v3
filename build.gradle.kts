plugins {
    kotlin("jvm") version "2.2.20"
    war
}

group = "org.eternals"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    compileOnly("org.glassfish:jakarta.faces:4.0.0")

    implementation("org.primefaces:primefaces:13.0.0:jakarta")

    implementation("org.hibernate.orm:hibernate-core:6.2.7.Final")
    implementation("org.postgresql:postgresql:42.7.7")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
