package osrs.rsbox.matcher.gui.api

/**
 * Represents a gui interface
 */
interface Gui {

    /**
     * Starts the gui interface
     */
    fun start(args: Array<String>)

    /**
     * Stops the gui interface
     */
    fun stop()
}