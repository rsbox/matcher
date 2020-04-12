package osrs.rsbox.matcher.gui.fragments

import javafx.geometry.Orientation
import javafx.scene.control.SelectionMode
import javafx.scene.control.SplitPane
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.asm.Method
import osrs.rsbox.matcher.gui.controller.EntryListController
import tornadofx.Fragment
import tornadofx.listview
import tornadofx.onChange

/**
 * Represents the left class entry view
 */
class LeftFragment : Fragment() {

    private val entryListController: EntryListController by inject()

    override val root = SplitPane()

    init {
        with(root) {
            orientation = Orientation.VERTICAL
            prefWidth = 200.0

            /**
             * The class entry list view
             */
            listview<Class> {
                cellFormat {
                    text = it.name
                }

                selectionModel.selectionMode = SelectionMode.SINGLE

                selectionModel.selectedItems.onChange {
                    if(it.list.isEmpty()) {
                        return@onChange
                    }

                    val selectedClass = it.list.first() ?: return@onChange
                    entryListController.methodList.items.setAll(selectedClass.methods)
                }

                entryListController.classList = this
            }

            /**
             * Method entry list view
             */
            listview<Method> {
                cellFormat {
                    text = "${it.clazz.name}.${it.name}${it.desc}"
                }

                entryListController.methodList = this
            }

            listview<Any> {}

            setDividerPosition(0, 0.6)
            setDividerPosition(1, 0.85)
        }
    }
}