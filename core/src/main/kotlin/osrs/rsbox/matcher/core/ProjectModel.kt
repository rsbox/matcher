package osrs.rsbox.matcher.core

import osrs.rsbox.matcher.common.Injectable
import osrs.rsbox.matcher.core.api.IProjectModel
import java.io.File

/**
 * The implementation of the project model.
 */
class ProjectModel : IProjectModel, Injectable {

    override var projectName: String = "Unnamed Project"

    override lateinit var inputjar: File

    override lateinit var referenceJar: File
}