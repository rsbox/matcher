package osrs.rsbox.matcher

import org.koin.dsl.module
import osrs.rsbox.matcher.core.ProjectModel
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.gui.MatcherGui
import osrs.rsbox.matcher.gui.api.Gui

/**
 * Koin module declaration.
 */
val module = module {
    single<Gui> { MatcherGui(get()) }
    single<IProjectModel> { ProjectModel() }
}