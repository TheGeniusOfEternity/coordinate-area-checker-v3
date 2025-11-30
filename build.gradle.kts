plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.allopen") version "1.9.0"
    war
}

group = "org.eternals"
version = "4.0.0-Release"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:3.0.0")

    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.glassfish:jakarta.faces:4.0.0")

    implementation("org.primefaces:primefaces:13.0.0:jakarta")

    implementation("org.hibernate.orm:hibernate-core:6.2.7.Final")
    implementation("org.postgresql:postgresql:42.7.7")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.0")
}

allOpen {
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("jakarta.transaction.Transactional")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
