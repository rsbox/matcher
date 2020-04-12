package osrs.rsbox.matcher.core

import org.koin.core.inject
import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.common.Injectable
import osrs.rsbox.matcher.gui.api.Gui

/**
 * The core object.
 */
object Core : Injectable {

    /**
     * Dependency injected gui.
     */
    private val gui: Gui by inject()

    /**
     * The main core method.
     */
    fun main(args: Array<String>) {
        Logger.info("Initializing...")

        /**
         * Start the gui
         */
        gui.start(args)
    }
}