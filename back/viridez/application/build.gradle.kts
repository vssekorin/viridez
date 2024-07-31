import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":core"))
    implementation(project(":api"))
    implementation(project(":web"))
    implementation(project(":telegram"))

    implementation("org.springframework.boot:spring-boot-autoconfigure")
    testImplementation("com.lemonappdev:konsist:0.15.1")
    testImplementation("io.kotest:kotest-assertions-core:5.9.1")
}

tasks.withType<BootJar> {
    archiveBaseName = "viridez"
    destinationDirectory = file(project.rootProject.layout.buildDirectory)
}
