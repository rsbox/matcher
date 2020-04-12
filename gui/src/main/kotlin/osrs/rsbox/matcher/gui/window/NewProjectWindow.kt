package osrs.rsbox.matcher.gui.window

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.control.ListView
import javafx.scene.control.SelectionMode
import javafx.stage.FileChooser
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

    /**
     * Observables
     */
    private val inputJars = mutableListOf<File>().asObservable()
    private val referenceJars = mutableListOf<File>().asObservable()

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

                        selectionModel.selectionMode = SelectionMode.SINGLE

                        inputJars.onChange {
                            items.setAll(it.list)
                        }

                    }
                    hbox(1) {
                        button("Add").action { addJarFile(Target.INPUT) }
                        button("Remove").action { removeSelectedJars(Target.INPUT) }
                    }
                }

                fieldset("Reference Jar") {
                    listview<File> {
                        prefWidth = 245.0
                        prefHeight = 50.0

                        model.referenceJarList = this

                        selectionModel.selectionMode = SelectionMode.SINGLE

                        referenceJars.onChange {
                            items.setAll(it.list)
                        }
                    }
                    hbox(1) {
                        button("Add").action { addJarFile(Target.REFERENCE) }
                        button("Remove").action { removeSelectedJars(Target.REFERENCE) }
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
     * Opens a file selection window and returns a single [File]
     */
    private fun openJarChooser(): File {
        return chooseFile("Choose Jar", mode = FileChooserMode.Single, filters = arrayOf(FileChooser.ExtensionFilter("jar", "*.jar"))).first()
    }

    private fun addJarFile(target: Target) {
        val targetObservable = when(target) {
            Target.INPUT -> inputJars
            Target.REFERENCE -> referenceJars
        }

        if(targetObservable.size > 0) {
            alert(Alert.AlertType.ERROR, "Oh Snap!", "You can only have one $target jar selected.")
            return
        }

        val jarFile = this.openJarChooser()
        targetObservable.add(jarFile)
    }

    private fun removeSelectedJars(target: Target) {
        val targetObservable = when(target) {
            Target.INPUT -> inputJars
            Target.REFERENCE -> referenceJars
        }

        val targetList = when(target) {
            Target.INPUT -> model.inputJarList
            Target.REFERENCE -> model.referenceJarList
        }

        val selections = targetList.selectionModel.selectedItems
        targetObservable.removeAll(selections)
    }

    private enum class Target {
        INPUT,
        REFERENCE;
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