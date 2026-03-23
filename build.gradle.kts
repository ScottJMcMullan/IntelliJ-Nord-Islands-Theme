plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

group = "com.scottmcmullan"
version = "1.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

sourceSets {
    main {
        resources.srcDir("resources")
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2025.3")
    }
}