@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version Project.kotlinVersion
    id("com.github.johnrengelman.shadow") version Plugin.shadowJar
    application
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "osrs.rsbox"
    version = Project.version

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("stdlib"))
        implementation(kotlin("reflect"))

        tinylog()
        koin()
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions {
            jvmTarget = Project.javaVersion.toString()
            version = Project.kotlinApiVersion
            apiVersion = Project.kotlinApiVersion
        }
    }
}

apply(plugin = "application")
apply(plugin = "com.github.johnrengelman.shadow")

application {
    mainClassName = "osrs.rsbox.matcher.Main"
}

tasks.withType<ShadowJar>() {
    @Suppress("DEPRECATION")
    archiveName = "matcher.jar"
}

dependencies {
    implementation(project(":common"))
    implementation(project(":core"))
    implementation(project(":core:core-api"))
    implementation(project(":gui"))
    implementation(project(":gui:gui-api"))
}