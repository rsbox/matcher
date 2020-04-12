package osrs.rsbox.matcher.gui.controller

import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.gui.window.NewProjectWindow
import tornadofx.Controller

/**
 * The controller used for menu bar actions
 */
class MenuController : Controller() {

    /**
     * Opens the new project window.
     */
    fun createNewProject() {
        Logger.info("Opening new project window.")
        NewProjectWindow().openModal()
    }
}