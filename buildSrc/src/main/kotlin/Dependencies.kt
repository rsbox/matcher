import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.DependencyHandlerScope

object Project {
    const val version = "1.0"
    const val kotlinVersion = "1.3.71"
    const val kotlinApiVersion = "1.3"
    const val gradleVersion = "6.2.2"
    val javaVersion = JavaVersion.VERSION_11
}

object Plugin {
    const val shadowJar = "5.2.0"
}

object Library {
    private object Version {
        const val tinylog = "2.1.1"
        const val koin = "2.1.5"
        const val tornadofx = "1.7.20"
        const val asm = "8.0.1"
        const val fernflower = "1.0.0.6"
        const val procyon = "0.5.33.6"
    }

    const val tinylogApi = "org.tinylog:tinylog-api-kotlin:${Version.tinylog}"
    const val tinylogImpl = "org.tinylog:tinylog-impl:${Version.tinylog}"
    const val koinCore = "org.koin:koin-core:${Version.koin}"
    const val koinCoreExt = "org.koin:koin-core-ext:${Version.koin}"
    const val koinTest = "org.koin:koin-test:${Version.koin}"
    const val tornadofx = "no.tornado:tornadofx:${Version.tornadofx}"
    const val asm = "org.ow2.asm:asm:${Version.asm}"
    const val asmCommons = "org.ow2.asm:asm-commons:${Version.asm}"
    const val asmUtil = "org.ow2.asm:asm-util:${Version.asm}"
    const val asmTree = "org.ow2.asm:asm-tree:${Version.asm}"
    const val fernflower = "org.jetbrains:intellij-fernflower:${Version.fernflower}"
    const val procyon = "org.bitbucket.mstrobel:procyon-compilertools:${Version.procyon}"
}

fun DependencyHandlerScope.tinylog() {
    "implementation"(Library.tinylogApi)
    "implementation"(Library.tinylogImpl)
}

fun DependencyHandlerScope.koin() {
    "implementation"(Library.koinCore)
    "implementation"(Library.koinCoreExt)
    "testImplementation"(Library.koinTest)
}

fun DependencyHandlerScope.asm() {
    "implementation"(Library.asm)
    "implementation"(Library.asmUtil)
    "implementation"(Library.asmCommons)
    "implementation"(Library.asmTree)
}