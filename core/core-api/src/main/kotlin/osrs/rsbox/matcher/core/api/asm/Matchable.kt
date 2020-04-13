package osrs.rsbox.matcher.core.api.asm

/**
 * Represents an ASM type which is matchable.
 */
interface Matchable<T> {

    /**
     * The matched type.
     */
    var match: T?
}