plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "com.eripe14"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()

    maven { url = uri("https://repo.panda-lang.org/releases") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
}


dependencies {
    // Spigot api
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")

    // Kyori Adventure
    implementation("net.kyori:adventure-platform-bukkit:4.3.0")
    implementation("net.kyori:adventure-text-minimessage:4.13.0")

    // LiteCommands
    implementation("dev.rollczi:litecommands-bukkit:3.4.0")
}

tasks {
    runServer {
        minecraftVersion("1.19.4")
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}