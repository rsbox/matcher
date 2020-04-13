package osrs.rsbox.matcher.core.api.asm

import org.objectweb.asm.tree.MethodNode

/**
 * Represents an ASM method which is contained in a [Class]
 */
class Method(val group: ClassGroup, val clazz: Class, val node: MethodNode) : Matchable<Method> {

    /**
     * The matched method.
     */
    override var match: Method? = null

    /**
     * The name of the method.
     */
    val name: String get() = node.name

    /**
     * The descriptor of the method.
     */
    val desc: String get() = node.desc

}