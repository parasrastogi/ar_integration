package com.example.ar_integration.core

import com.example.ar_integration.core.ErrorLog

interface ErrorLogger {

    /**
     * This method logs errors.
     */
    fun logError(errorLog: ErrorLog)

}