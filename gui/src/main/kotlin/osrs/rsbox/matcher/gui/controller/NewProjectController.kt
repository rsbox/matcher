package osrs.rsbox.matcher.gui.controller

import javafx.scene.control.Alert
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.gui.MatcherView
import osrs.rsbox.matcher.gui.window.NewProjectWindow
import tornadofx.Controller
import tornadofx.alert
import java.io.File

/**
 * New project controller actions.
 */
class NewProjectController : Controller() {

    /**
     * Injected project model
     */
    private val projectModel: IProjectModel by di()

    /**
     * Injected new project view
     */
    private val newProjectWindow: NewProjectWindow by inject()

    /**
     * Creates the new project.
     */
    fun createProject(projectName: String?, inputJar: List<File>, referenceJar: List<File>): Boolean {
        if(projectName == null || projectName == "" || inputJar.isEmpty() || referenceJar.isEmpty()) {
            alert(Alert.AlertType.ERROR, "Oh Snap!", "You had an error in your project configuration.")
            return false
        }

        val input = inputJar.first()
        val reference = referenceJar.first()

        projectModel.projectName = projectName
        projectModel.inputjar = input
        projectModel.referenceJar = reference

        /**
         * Update the matcher view title to the new project name
         */
        find<MatcherView>().title = "RSBox Matcher - $projectName"

        return true
    }
}