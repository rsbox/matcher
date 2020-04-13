package osrs.rsbox.matcher.core.decompiler

import com.strobel.assembler.metadata.Buffer
import com.strobel.assembler.metadata.ClasspathTypeLoader
import com.strobel.assembler.metadata.CompositeTypeLoader
import com.strobel.assembler.metadata.ITypeLoader
import com.strobel.decompiler.DecompilerSettings
import com.strobel.decompiler.PlainTextOutput
import org.objectweb.asm.ClassWriter
import org.tinylog.kotlin.Logger
import osrs.rsbox.matcher.core.api.asm.Class
import osrs.rsbox.matcher.core.api.decompiler.Decompiler
import osrs.rsbox.matcher.core.asm.AsmEnvironment

/**
 * An implementation of the Procyon decompiler.
 */
class ProcyonDecompiler : Decompiler {

    /**
     * Decompile a [Class] asm object.
     */
    override fun decompile(clazz: Class): String {
        val settings = DecompilerSettings.javaDefaults()
        settings.showSyntheticMembers = true
        settings.typeLoader = CompositeTypeLoader(
            TypeLoader(clazz),
            ClasspathTypeLoader()
        )

        val out = PlainTextOutput()
        com.strobel.decompiler.Decompiler.decompile(clazz.name, out, settings)

        return out.toString()
    }

    private class TypeLoader(val clazz: Class) : ITypeLoader {

        override fun tryLoadType(internalName: String, buffer: Buffer): Boolean {
            val cls = clazz.group.classes.firstOrNull { it.name == internalName }

            if(cls == null) {
                Logger.error("Decompile: Missing class: $internalName from class group.")
                return false
            }

            val writer = ClassWriter(0)
            cls.node.accept(writer)

            val data = writer.toByteArray()

            buffer.reset(data.size)
            buffer.putByteArray(data, 0, data.size)
            buffer.position(0)

            return true
        }
    }
}