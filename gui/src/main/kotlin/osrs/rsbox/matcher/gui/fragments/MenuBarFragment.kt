package osrs.rsbox.matcher.gui.fragments

import tornadofx.*
import kotlin.system.exitProcess

/**
 * The top menubar displayed in the primary view.
 */
class MenuBarFragment : Fragment() {

    override val root = menubar {
        menu("File") {
            item("New Project")
            item("Open Project")
            separator()
            item("Save Project")
            separator()
            item("Exit").action { exitProcess(0) }
        }
    }
}