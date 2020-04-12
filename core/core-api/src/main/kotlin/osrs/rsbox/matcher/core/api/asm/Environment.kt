package osrs.rsbox.matcher.core.api.asm

import osrs.rsbox.matcher.core.api.IProjectModel

/**
 * Represents an environment with both input and reference groups loaded.
 */
interface Environment {

    /**
     * The input jar class group
     */
    val inputGroup: ClassGroup

    /**
     * The reference jar class group.
     */
    val referenceGroup: ClassGroup

    /**
     * Loads both the input and reference groups from the associated project model.
     */
    fun loadGroups(model: IProjectModel)
}