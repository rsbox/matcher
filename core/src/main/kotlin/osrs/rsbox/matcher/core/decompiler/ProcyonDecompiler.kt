package osrs.rsbox.matcher.core.decompiler

import com.strobel.decompiler.DecompilerSettings
import com.strobel.decompiler.PlainTextOutput
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.decompiler.Decompiler

/**
 * An implementation of the Procyon decompiler.
 */
class ProcyonDecompiler : Decompiler {

    override fun decompile(clazz: Class): String {
        val settings = DecompilerSettings.javaDefaults()
        settings.showSyntheticMembers = true

        val out = PlainTextOutput()
        com.strobel.decompiler.Decompiler.decompile(clazz.name, out, settings)

        return out.toString()
    }
}