import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.1.0")
}

tasks.withType<BootJar> {
    enabled = false
}
