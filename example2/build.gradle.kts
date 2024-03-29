plugins {
    id("application")
    id("io.spring.dependency-management").version("1.0.7.RELEASE")
}

group = "dev.jakapw"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("io.projectreactor:reactor-bom:2023.0.4")
    }
}

dependencies {
    implementation("io.projectreactor:reactor-core")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass = "dev.jakapw.Main"
}

tasks.test {
    useJUnitPlatform()
}