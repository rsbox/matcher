package osrs.rsbox.matcher.gui.window

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.control.ListView
import osrs.rsbox.matcher.gui.controller.NewProjectController
import tornadofx.*
import java.io.File

/**
 * The new project window / dialog.
 * Displays the forms needed to create a new project.
 */
class NewProjectWindow : View("Create New Project") {

    /**
     * The new project model
     */
    private val model = NewProjectModel()

    /**
     * Controllers
     */
    private val newProjectController: NewProjectController by inject()

    override val root = Form()

    init {
        with(root) {

            fieldset("Project Name") {
                textfield(model.projectName) {
                    prefWidth = 500.0
                }
            }

            hbox(5) {
                fieldset("Input Jar") {
                    listview<File> {
                        prefWidth = 245.0
                        prefHeight = 50.0

                        model.inputJarList = this
                    }
                    hbox(1) {
                        button("Add")
                        button("Remove")
                    }
                }

                fieldset("Reference Jar") {
                    listview<File> {
                        prefWidth = 245.0
                        prefHeight = 50.0

                        model.referenceJarList = this
                    }
                    hbox(1) {
                        button("Add")
                        button("Remove")
                    }
                }
            }

            hbox(5) {
                alignment = Pos.CENTER_RIGHT

                button("Cancel").action { close() }
                button("Create")
            }
        }
    }

    /**
     * Private model class
     */
    private class NewProjectModel {
        /**
         * The name of the project.
         */
        val projectName = SimpleStringProperty()

        var inputJarList: ListView<File> by singleAssign()
        var referenceJarList: ListView<File> by singleAssign()
    }
}