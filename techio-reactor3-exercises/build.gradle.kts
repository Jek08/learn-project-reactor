plugins {
    id("application")
}

group = "dev.jakapw"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("io.projectreactor:reactor-bom:2023.0.4"))
    implementation("io.projectreactor:reactor-core")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.projectreactor:reactor-test:3.6.4")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

application {
    mainClass = "io.pivotal.literx.Main"
}

tasks.test {
    useJUnitPlatform()
}