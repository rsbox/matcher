package osrs.rsbox.matcher

import org.koin.core.context.startKoin
import osrs.rsbox.matcher.core.Core

/**
 * Main object
 */
object Main {

    /**
     * Main method
     */
    @JvmStatic
    fun main(args: Array<String>) {
        this.startDependencyInjector()

        /**
         * Invoke the core application
         */
        Core.main(args)
    }

    /**
     * Starts the koin dependency injector
     */
    private fun startDependencyInjector() {
        startKoin { modules(
            module
        ) }
    }
}