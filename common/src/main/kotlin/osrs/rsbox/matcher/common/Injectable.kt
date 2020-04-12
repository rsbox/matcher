package osrs.rsbox.matcher.common

import org.koin.core.KoinComponent

/**
 * Just an alias interface for [KoinComponent]
 * Makes code more obvious that the subtype is using dependency injection
 * since koin may not be well known.
 */
interface Injectable : KoinComponent