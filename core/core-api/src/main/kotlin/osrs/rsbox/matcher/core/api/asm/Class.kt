package osrs.rsbox.matcher.core.api.asm

import org.objectweb.asm.tree.ClassNode

/**
 * Represents an ASM loaded class file.
 */
class Class(val group: ClassGroup, val node: ClassNode) : Matchable<Class> {

    /**
     * The matched class.
     */
    override var match: Class? = null

    /**
     * The name of the class
     */
    val name: String get() = node.name

    /**
     * The name of the extended class.
     * By default this is java/lang/Object.
     */
    val superName: String get() = node.superName

    /**
     * The methods contained in this class.
     */
    val methods = node.methods.map { Method(group, this, it) }
}