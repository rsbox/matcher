package osrs.rsbox.matcher.gui

import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.gui.api.Gui
import tornadofx.find
import tornadofx.launch

/**
 * The gui implementation
 */
class MatcherGui : Gui {

    /**
     * Starts the gui interface application.
     */
    override fun start(args: Array<String>) {
        Logger.info("Launching matcher gui.")
        launch<MatcherApp>(args)
    }

    /**
     * Stops the gui interface.
     */
    override fun stop() {
        Logger.info("Stopping matcher gui.")
        find<MatcherView>().close()
    }
}