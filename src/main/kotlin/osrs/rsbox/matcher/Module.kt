package osrs.rsbox.matcher

import org.koin.dsl.bind
import org.koin.dsl.module
import osrs.rsbox.matcher.core.ProjectModel
import osrs.rsbox.matcher.core.api.IProjectModel
import osrs.rsbox.matcher.core.api.asm.ClassGroup
import osrs.rsbox.matcher.core.api.asm.Environment
import osrs.rsbox.matcher.core.api.decompiler.Decompiler
import osrs.rsbox.matcher.core.asm.AsmClassGroup
import osrs.rsbox.matcher.core.asm.AsmEnvironment
import osrs.rsbox.matcher.core.decompiler.ProcyonDecompiler
import osrs.rsbox.matcher.gui.MatcherGui
import osrs.rsbox.matcher.gui.api.Gui

/**
 * Koin module declaration.
 */
val module = module {
    single<Gui> { MatcherGui(get()) }
    single<IProjectModel> { ProjectModel() }
    single<Decompiler> { ProcyonDecompiler() }

    /**
     * Asm
     */
    single { AsmEnvironment() } bind Environment::class
    factory { AsmClassGroup(get()) } bind ClassGroup::class
}