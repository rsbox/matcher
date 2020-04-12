package osrs.rsbox.matcher.gui.tab

import javafx.scene.layout.Priority
import osrs.rsbox.matcher.core.api.asm.ClassGroup
import tornadofx.*

class TabEntryView(private val group: ClassGroup) : Fragment() {

    override val root = tabpane {
        hgrow = Priority.ALWAYS
        vgrow = Priority.ALWAYS

        tab("Source") {
            isClosable = false
        }
    }
}