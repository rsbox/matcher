package osrs.rsbox.matcher.core.api.asm

import org.objectweb.asm.tree.MethodNode

/**
 * Represents an ASM method which is contained in a [Class]
 */
class Method(val group: ClassGroup, val clazz: Class, val node: MethodNode) {

    val name: String get() = node.name

    val desc: String get() = node.desc

}