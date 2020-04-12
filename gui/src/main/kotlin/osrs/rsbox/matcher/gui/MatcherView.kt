package osrs.rsbox.matcher.gui

import javafx.scene.layout.BorderPane
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.gui.fragments.LeftFragment
import osrs.rsbox.matcher.gui.fragments.MenuBarFragment
import tornadofx.View

/**
 * The main matcher view.
 */
class MatcherView : View() {

    /**
     * Injected project model.
     */
    private val projectModel: IProjectModel by di()

    override val root = BorderPane()

    init {
        title = "RSBox Matcher - ${projectModel.projectName}"

        with(root) {
            setPrefSize(1280.0, 850.0)

            top = find<MenuBarFragment>().root
            left = find<LeftFragment>().root
        }
    }

}