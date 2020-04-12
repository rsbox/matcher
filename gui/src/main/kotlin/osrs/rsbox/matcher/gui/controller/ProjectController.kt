package osrs.rsbox.matcher.gui.controller

import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.core.api.asm.Environment
import osrs.rsbox.matcher.gui.MatcherView
import osrs.rsbox.matcher.gui.fragments.CenterFragment
import tornadofx.Controller

/**
 * A global project controller.
 */
class ProjectController : Controller() {

    private val environment: Environment by di()

    /**
     * Lazy injected project model.
     * Waits until a project is either created or loaded from a project save file.
     */
    private val projectModel: IProjectModel by di()

    /**
     * Injected controllers
     */
    private val entryListController: EntryListController by inject()

    /**
     * Initializes a new project and updates gui components.
     */
    fun initProject() {
        Logger.info("Initializing project name: '${projectModel.projectName}'.")

        /**
         * Trigger ASM to load both of the input and reference groups.
         */
        environment.loadGroups(projectModel)

        /**
         * Update the left class entry list.
         */
        environment.inputGroup.classes.forEach { c ->
            entryListController.classList.items.add(c)
        }

        find<MatcherView>().root.center = CenterFragment().root
    }
}