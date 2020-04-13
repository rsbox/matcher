package osrs.rsbox.matcher.core.api.decompiler

import osrs.rsbox.matcher.core.api.asm.Class

/**
 * Represents a decompiler type.
 * The implementation is determined by the type set in the
 * koin dependency injector.
 */
interface Decompiler {

    /**
     * Decompile a [Class] asm type.
     */
    fun decompile(clazz: Class): String
}