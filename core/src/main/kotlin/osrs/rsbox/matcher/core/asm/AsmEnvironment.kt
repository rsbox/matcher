package osrs.rsbox.matcher.core.asm

import org.koin.core.inject
import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.common.Injectable
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.core.api.asm.Environment

/**
 * The ASM loaded environment.
 */
class AsmEnvironment : Environment, Injectable {

    /**
     * The lazy injected input group object
     */
    override val inputGroup: AsmClassGroup by inject()

    /**
     * The lazy injected reference group object
     */
    override val referenceGroup: AsmClassGroup by inject()

    /**
     * Loads both the input and reference groups given a [model]
     */
    override fun loadGroups(model: IProjectModel) {
        Logger.info("Loading input and reference jar groups.")

        inputGroup.loadJar(model.inputjar)
        referenceGroup.loadJar(model.referenceJar)

        Logger.info("Completed input and reference group loading.")
    }
}