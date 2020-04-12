package osrs.rsbox.matcher.gui.fragments

import javafx.geometry.Orientation
import javafx.scene.control.SplitPane
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.gui.controller.EntryListController
import tornadofx.Fragment
import tornadofx.listview

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

            listview<Class> {
                cellFormat {
                    text = it.name
                }

                entryListController.classList = this
            }
            listview<Any> {}
            listview<Any> {}

            setDividerPosition(0, 0.6)
            setDividerPosition(1, 0.85)
        }
    }
}