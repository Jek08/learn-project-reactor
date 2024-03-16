plugins {
    id("application")
    id("io.freefair.lombok") version "8.6"
}

group = "dev.jakapw"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("io.projectreactor:reactor-bom:2023.0.4"))
    implementation("io.projectreactor:reactor-core")
    implementation("org.slf4j:slf4j-api:2.0.12")
    testImplementation("org.slf4j:slf4j-simple:2.0.12")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.projectreactor:reactor-test:3.6.4")
}

application {
    mainClass = "dev.jakapw.Main"
}

tasks.test {
    useJUnitPlatform()
}