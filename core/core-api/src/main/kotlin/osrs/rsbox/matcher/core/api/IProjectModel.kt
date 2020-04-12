package osrs.rsbox.matcher.core.api

import java.io.File

/**
 * Represents an implementation of a project configuration / model.
 */
interface IProjectModel {

    /**
     * The name of the project.
     */
    var projectName: String

    /**
     * The input jar file to be mapped.
     */
    var inputjar: File

    /**
     * The reference jar file to build mappings from.
     */
    var referenceJar: File
}