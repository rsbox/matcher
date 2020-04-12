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

    init {
        with(root) {

            this.add(TabEntryView(environment.inputGroup).root)
            this.add(TabEntryView(environment.referenceGroup).root)

            setDividerPosition(0, 0.5)
        }
    }
}