package com.bhi.commonlib.app

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Holds background executors to perform specific background operations on their respective ExecutorService.
 */
object AppExecutors {

    private val THREAD_COUNT = (Runtime.getRuntime().availableProcessors() * 2) + 1

    val SINGLE_EXECUTOR = Executors.newSingleThreadExecutor()

    val POOL_EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT)

    val UI_EXECUTOR = object : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    fun runOnUIThreadDelayed(runnable: Runnable, delayMS: Long) {
        val mainThreadHandler = Handler(Looper.getMainLooper())
        mainThreadHandler.postDelayed(runnable, delayMS)
    }
}