package osrs.rsbox.matcher.core.asm

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.asm.ClassGroup
import java.io.File
import java.util.jar.JarFile

/**
 * Represents an ASM implementation of the classes.
 */
class AsmClassGroup(override val environment: AsmEnvironment) : ClassGroup {

    override val classes = mutableListOf<Class>()

    /**
     * Adds a [ClassNode] to the class store [classes].
     */
    fun add(node: ClassNode): Boolean {
        return classes.add(Class(this, node))
    }

    /**
     * Loads a jar from a [file]
     */
    fun loadJar(file: File) {
        Logger.info("Loading classes from jar file: '${file.name}'.")

        JarFile(file).use { jar ->
            jar.stream().iterator().asSequence()
                .filter { it.name.endsWith(".class") }
                .forEach {
                    val node = ClassNode()
                    val reader = ClassReader(jar.getInputStream(it))
                    reader.accept(node, ClassReader.SKIP_FRAMES or ClassReader.SKIP_DEBUG)
                    this.add(node)
                }
        }
    }
}