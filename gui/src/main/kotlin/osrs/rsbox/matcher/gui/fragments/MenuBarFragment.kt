package osrs.rsbox.matcher.gui.fragments

import osrs.rsbox.matcher.gui.controller.MenuController
import tornadofx.*
import kotlin.system.exitProcess

/**
 * The top menubar displayed in the primary view.
 */
class MenuBarFragment : Fragment() {

    /**
     * Controllers
     */
    private val menuController: MenuController by inject()

    override val root = menubar {
        menu("File") {
            item("New Project").action { menuController.createNewProject() }
            item("Open Project")
            separator()
            item("Save Project")
            separator()
            item("Exit").action { exitProcess(0) }
        }
    }
}