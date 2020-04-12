package osrs.rsbox.matcher.core.api.asm

import org.objectweb.asm.tree.ClassNode

/**
 * Represents an ASM loaded class group.
 */
interface ClassGroup {

    /**
     * The environment this group belongs to.
     */
    val environment: Environment

    /**
     * A store of classes
     */
    val classes: MutableList<Class>
}