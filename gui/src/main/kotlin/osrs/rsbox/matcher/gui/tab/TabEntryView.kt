package osrs.rsbox.matcher.gui.tab

import javafx.scene.control.TextArea
import javafx.scene.layout.Priority
import osrs.rsbox.matcher.common.task.await
import osrs.rsbox.matcher.common.task.future
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.asm.ClassGroup
import osrs.rsbox.matcher.core.api.decompiler.Decompiler
import tornadofx.*
import java.util.concurrent.CompletableFuture

class TabEntryView(private val group: ClassGroup) : Fragment() {

    /**
     * The source tab textarea field.
     */
    var sourceTextArea: TextArea by singleAssign()

    /**
     * Dependency injected decompiler.
     */
    private val decompiler: Decompiler by di()

    override val root = tabpane {
        hgrow = Priority.ALWAYS
        vgrow = Priority.ALWAYS

        tab("Source") {
            isClosable = false

            textarea {
                hgrow = Priority.ALWAYS
                vgrow = Priority.ALWAYS
                isEditable = false

                sourceTextArea = this
            }
        }
    }

    /**
     * Decompiles the source of a input [Class] asm object.
     */
    fun decompileClass(clazz: Class) {
        sourceTextArea.text = "Decompiling..."
        val sourceText = decompiler.decompile(clazz)

        sourceTextArea.text = sourceText
    }
}