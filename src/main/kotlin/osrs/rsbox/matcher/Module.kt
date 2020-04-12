package osrs.rsbox.matcher

import org.koin.dsl.module
import osrs.rsbox.matcher.gui.MatcherGui
import osrs.rsbox.matcher.gui.api.Gui
import osrs.rsbox.matcher.gui.fragments.MenuBarFragment

/**
 * Koin module declaration.
 */
val module = module {
    single<Gui> { MatcherGui() }
}