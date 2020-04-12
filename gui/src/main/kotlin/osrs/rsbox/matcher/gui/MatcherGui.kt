package osrs.rsbox.matcher.gui

import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.common.Injectable
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.gui.api.Gui
import tornadofx.DIContainer
import tornadofx.FX
import tornadofx.find
import tornadofx.launch
import kotlin.reflect.KClass

/**
 * The gui implementation
 * @param projectModel The project model for this application.
 */
class MatcherGui(private val projectModel: IProjectModel) : Gui {

    /**
     * Starts the gui interface application.
     */
    override fun start(args: Array<String>) {
        Logger.info("Launching matcher gui.")

        /**
         * Create koin dependency injector container
         */
        this.buildKoinFXInject()

        /**
         * Launch the FX application
         */
        launch<MatcherApp>(args)
    }

    /**
     * Stops the gui interface.
     */
    override fun stop() {
        Logger.info("Stopping matcher gui.")
        find<MatcherView>().close()
    }

    /**
     * Builds a wrapper support for the koin dependency injector to work alongside the built-in kodein injector.
     */
    private fun buildKoinFXInject() {
        FX.dicontainer = object : DIContainer, Injectable {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return getKoin().get(clazz = type, qualifier = null, parameters = null)
            }
        }
    }
}