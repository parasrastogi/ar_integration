package com.bhi.commonlib.util

import timber.log.Timber


/***
 * @author Rahul Rastogi
 *
 * Provides logging feature while debugging app. This class prints the class name in logs so that, it
 * finding out the logging class easily.
 */
object Logger {

    private const val MAX_LOG_CHAR_LIMIT = 4000
    private const val LOG_PREFIX = "NHN::"
    var isLogEnabled: Boolean = false

    fun d(o: Any, msg: String) {
        if (isLogEnabled) {
            if (msg.length > MAX_LOG_CHAR_LIMIT) {
                val chunkCount: Int = msg.length / MAX_LOG_CHAR_LIMIT

                for (i in 0..chunkCount) {
                    val max = MAX_LOG_CHAR_LIMIT * (i + 1)

                    if (max >= msg.length) {
                        Timber.d("%s%s%s", LOG_PREFIX, o.javaClass.toString(),
                                "Chunk $i/$chunkCount: ${msg.substring(4000 * i)}")
                    } else {
                        Timber.d("%s%s%s", LOG_PREFIX, o.javaClass.toString(),
                                "Chunk $i/$chunkCount: ${msg.substring(4000 * i, max)}")
                    }
                }
            } else {
                Timber.d("%s%s%s", LOG_PREFIX, o.javaClass.toString(), msg)
            }
        }
    }

    fun e(o: Any, msg: String) {
        if (isLogEnabled) {
            if (msg.length > MAX_LOG_CHAR_LIMIT) {
                val chunkCount: Int = msg.length / MAX_LOG_CHAR_LIMIT

                for (i in 0..chunkCount) {
                    val max = MAX_LOG_CHAR_LIMIT * (i + 1)

                    if (max >= msg.length) {
                        Timber.e("%s%s%s", LOG_PREFIX, o.javaClass.toString(),
                                "Chunk $i/$chunkCount: ${msg.substring(4000 * i)}")
                    } else {
                        Timber.e("%s%s%s", LOG_PREFIX, o.javaClass.toString(),
                                "Chunk $i/$chunkCount: ${msg.substring(4000 * i, max)}")
                    }
                }
            } else {
                Timber.e("%s%s%s", LOG_PREFIX, o.javaClass.toString(), msg)
            }
        }
    }
}
