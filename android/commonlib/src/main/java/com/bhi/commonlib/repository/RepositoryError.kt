package com.bhi.commonlib.repository

/**
 * Holds error details while repository operations fail due to any reason.
 */
data class RepositoryError(
        val errorType: ErrorType = ErrorType.OTHER,
        val message: String? = null
) {

    var errorCode: String? = null
}
