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

    implementation("org.glassfish:jakarta.faces:4.0.0")
    implementation("org.primefaces:primefaces:12.0.0")
    implementation("org.icefaces:icefaces-ace:4.3.0")
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
