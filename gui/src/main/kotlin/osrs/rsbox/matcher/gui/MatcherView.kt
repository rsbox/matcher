package osrs.rsbox.matcher.gui

import javafx.scene.layout.BorderPane
import osrs.rsbox.matcher.gui.fragments.MenuBarFragment
import tornadofx.View

/**
 * The main matcher view.
 */
class MatcherView : View("RSBox Matcher") {

    override val root = BorderPane()

    init {
        with(root) {
            setPrefSize(1280.0, 850.0)

            top = find<MenuBarFragment>().root
        }
    }
}