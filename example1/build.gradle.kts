plugins {
    id("application")
}

group = "dev.jakapw"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass = "dev.jakapw.Main"
}

tasks.test {
    useJUnitPlatform()
}