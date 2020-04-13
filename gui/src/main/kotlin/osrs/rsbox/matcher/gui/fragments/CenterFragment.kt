package osrs.rsbox.matcher.gui.fragments

import javafx.scene.control.SplitPane
import osrs.rsbox.matcher.core.api.asm.Environment
import osrs.rsbox.matcher.gui.tab.TabEntryView
import tornadofx.Fragment

/**
 * Represents the center view fragment.
 */
class CenterFragment : Fragment() {

    override val root = SplitPane()

    /**
     * Injected class environment
     */
    private val environment: Environment by di()

    val inputTabPane = TabEntryView(environment.inputGroup)
    val referenceTabPane = TabEntryView(environment.referenceGroup)

    init {
        with(root) {

            this.add(inputTabPane.root)
            this.add(referenceTabPane.root)

            setDividerPosition(0, 0.5)
        }
    }
}