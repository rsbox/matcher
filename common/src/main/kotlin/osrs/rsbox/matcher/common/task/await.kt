package osrs.rsbox.matcher.common.task

import java.util.concurrent.CompletableFuture
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun <T> CompletableFuture<T>.await(): T =
        suspendCoroutine { cont: Continuation<T> ->
            whenComplete { result, exception ->
                if(exception == null) {
                    cont.resume(result)
                } else {
                    cont.resumeWithException(exception)
                }
            }
        }