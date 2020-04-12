@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Project.kotlinVersion
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

application {
    mainClassName = "osrs.rsbox.matcher.Main"
}

dependencies {
    implementation(project(":common"))
    implementation(project(":core"))
    implementation(project(":gui"))
    implementation(project(":gui:gui-api"))
}