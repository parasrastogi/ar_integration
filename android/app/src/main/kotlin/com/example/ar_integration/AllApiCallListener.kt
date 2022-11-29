/*
package com.example.ar_integration

import android.widget.Toast
import com.android.volley.Request
import com.android.volley.VolleyError
import com.bhi.commonlib.ApiHeader
import com.bhi.commonlib.BaseResponse
import com.bhi.commonlib.Urls
import com.bhi.commonlib.app.AppConfig
import com.bhi.commonlib.util.GsonUtil
import com.bhi.commonlib.util.MyToast
import com.example.ar_integration.core.ErrorLog
import com.example.ar_integration.core.ErrorLogger
import com.myvolley.listeners.ApiCallback
import com.myvolley.listeners.GlobalApiListener
import com.myvolley.managers.ApiSessionManager
import com.myvolley.models.ApiError
import com.myvolley.models.NetworkResult
import com.myvolley.requests.ApiRequest
import com.myvolley.requests.multipart.MultipartRequest

*/
/**
 * This class listens to response/error of all API requests, if the object of this class is set as globalApiListener
 * in ApiManager class.
 *//*

class AllApiCallListener(*/
/*private val errorLogger: ErrorLogger,*//*
 private val userRepository: UserRepository) : GlobalApiListener {

    companion object {
        const val STATUS_CODE_UNAUTHORIZED = 401
    }

    private val whitelistedUrls = arrayOf(Urls.AUTH_VIA_UUP, Urls.GUEST_SIGN_UP)

    override fun onRequestPreExecute(request: Request<*>, onPreExecuteCompletion: () -> Unit) {
        //Adding common headers to be sent in each API call.
        request.headers?.put(ApiHeader.APP_VERSION_NAME, BuildConfig.VERSION_NAME)
        request.headers?.put(ApiHeader.PLATFORM, Platform.ANDROID)
        request.headers?.put(ApiHeader.CLIENT, BuildConfig.CLIENT_NAME)
        request.headers?.put(ApiHeader.CDP_WRITE_KEY, NHNApplication.instance.getString(R.string.segment_write_key))
        request.headers?.put(ApiHeader.CDP_CONTEXT, NHNApplication.analytics.analyticsContext.toJsonObject().toString())
        request.headers?.put(SegmentEventKey.ANONYMOUS_ID, NHNApplication.analytics.analyticsContext.traits().anonymousId())
        request.headers?.put(SegmentEventKey.GOOGLE_ANALYTICS_CLIENT_ID, NHNApplication.g_client_id)

        NHNApplication.apiIdlingResource.beginLoad(request.url)

        //Calling onPreExecuteCompletion() to notify that pre-execution has been completed and this API request
        //is now ready to be taken in the execution queue.

        val userRepository = UserRepository.getInstance(
                UserLocalDataSource.getInstance(),
                UserRemoteDataSource.getInstance()
        )

        //If user is logged in normally (non-guest) then must check for the Auth0 token validity.
        if (userRepository.getUser() != null
                && !userRepository.getUser()!!.isGuestUser
                && request.url !in whitelistedUrls.map { it.url }
        ) {
            Auth0Repository.getInstance().validateAuth0Credentials(
                    NHNApplication.instance,
                    {//on success
                        onPreExecuteCompletion()
                    },
                    { credentialsManagerException ->
                        //If credentialsManagerException is NULL then it means that no exception
                        //occurred while getting credentials and credentials weren't saved locally.
                        //Means, the user has been logged out.
                        if (userRepository.getUser() == null || (credentialsManagerException != null
                                        && credentialsManagerException.cause is NetworkErrorException)
                        ) {
                            onPreExecuteCompletion()
                        } else {
                            //If any exception occurs then
                            onSessionExpiration()
                        }
                    })
        } else {
            onPreExecuteCompletion()
        }
    }

    */
/**
     * Listens to all APIs success response.
     *//*

    override fun onResponse(request: Request<*>, response: Any?, networkResult: NetworkResult) {
        NHNApplication.apiIdlingResource.endLoad(request.url)

        //Logging API error
        logApiError(request, networkResult, false)

        if (request is ApiRequest<*>) {
            (request.mApiCallback as ApiCallback<Any>?)?.onResponse(response, networkResult)

        } else if (request is MultipartRequest) {
            (request.mApiCallback as ApiCallback<Any>?)?.onResponse(response, networkResult)
        }
    }

    */
/**
     * Listens to all APIs error.
     *//*

    override fun onErrorResponse(request: Request<*>, error: ApiError) {
        NHNApplication.apiIdlingResource.endLoad(request.url)

        //Logging API error
        val hasResponseParseError = (ApiError.PARSE_ERROR == error.errorType)
        logApiError(request, error.networkResult, hasResponseParseError)

        if (request is ApiRequest<*>) {
            if (error.networkResult?.statusCode == STATUS_CODE_UNAUTHORIZED) {
                refreshAuthToken(request)
            } else {
                request.mApiCallback?.onErrorResponse(error)
            }
        } else if (request is MultipartRequest) {
            if (error.networkResult?.statusCode == STATUS_CODE_UNAUTHORIZED) {
                refreshAuthToken(request)
            } else {
                request.mApiCallback?.onErrorResponse(error)
            }
        }
    }


    */
/**
     * This method logs API errors on remote server.
     *//*

    private fun logApiError(request: Request<*>, networkResult: NetworkResult?, hasResponseParseError: Boolean) {
        val requestJson = if (request.body != null) {
            String(request.body)
        } else {
            null
        }

        val responseJson = if (networkResult?.data != null) {
            String(networkResult.data)
        } else {
            null
        }

        val baseResponse = GsonUtil.fromJson<BaseResponse>(responseJson, BaseResponse::class.java)
        var apiErrorMessage = baseResponse?.errorMessage
        val responseCode = networkResult?.statusCode
                ?: 0
        val networkTimeMS = networkResult?.networkTimeMs?.toInt()
                ?: 0

        val hasApiFailure = responseCode < 200 || responseCode >= 300
        val hasApiResponseError: Boolean = (baseResponse?.error == true)

        if (hasApiFailure || hasApiResponseError || hasResponseParseError) {
            if (hasResponseParseError) {
                //Setting custom message in case response couldn't be parsed at app's end.
                apiErrorMessage = "RESPONSE_PARSE_ERROR"
            }

            val userId = userRepository.getUser()?.id
                    ?: 0

            //If it's Sign Up/Log In API then removing password from request json.
            */
/*if (request.url.startsWith(Urls.LOGIN.url, false) || request.url.startsWith(Urls.SIGN_UP.url, false)) {
                val authenticationRequest = GsonUtil.fromJson<AuthenticationRequest>(requestJson, AuthenticationRequest::class.java)
                authenticationRequest?.password = null
                requestJson = GsonUtil.toJson(authenticationRequest)

            } else if (request.url.startsWith(Urls.VALIDATE_OTP_AND_CHANGE_PASSWORD.url, false)) {
                val changePasswordRequest = GsonUtil.fromJson<ResetPasswordRequest>(requestJson, ResetPasswordRequest::class.java)
                changePasswordRequest?.oldPassword = null
                changePasswordRequest?.newPassword = null

                requestJson = GsonUtil.toJson(changePasswordRequest)

            } else if (request.url.startsWith(Urls.EDIT_PROFILE.url, false)) {
                val prospectUserDetailBasicDetails = GsonUtil.fromJson<ProspectUserDetailBasicDetails>(requestJson,
                        ProspectUserDetailBasicDetails::class.java)
                prospectUserDetailBasicDetails?.password = null

                requestJson = GsonUtil.toJson(prospectUserDetailBasicDetails)
            }*//*


            //Logging API error
            val apiErrorLog: ErrorLog = ApiErrorLog(
                    userId, getMethodName(request.method), request.url, requestJson, apiErrorMessage,
                    responseCode, networkTimeMS
            )
            errorLogger.logError(apiErrorLog)
        }
    }

    private fun getMethodName(methodType: Int): String {
        return when (methodType) {
            ApiRequest.GET ->
                "GET"
            ApiRequest.POST ->
                "POST"
            ApiRequest.PUT ->
                "PUT"
            ApiRequest.PATCH ->
                "PATCH"
            ApiRequest.DELETE ->
                "DELETE"
            ApiRequest.HEAD ->
                "HEAD"
            ApiRequest.OPTIONS ->
                "OPTIONS"
            ApiRequest.TRACE ->
                "TRACE"
            else ->
                "UNKNOWN"
        }
    }


    */
/**
     * Sending refresh auth token API request.
     *//*

    private fun refreshAuthToken(pendingRequest: Request<*>) {
        //If user has signed out from app by this time.
        if (ApiSessionManager.authToken == null) {
            return
        }

        val refreshTokenRequest = RefreshTokenRequest(
                ApiSessionManager.authToken!!.tokenValue,
                ApiSessionManager.getRefreshToken(NHNApplication.instance)!!
        )

        userRepository.refreshAuthToken(refreshTokenRequest,
                { response, headers ->
                    if (response.error) {
                        onSessionExpiration()
                    } else {
                        val newAuthToken: String = headers!![AppConfig.KEY_RECEIVING_ACCESS_TOKEN]!!
                        val newRefreshToken: String = headers[AppConfig.KEY_RECEIVING_REFRESH_TOKEN]!!

                        //Updating token values in application
                        ApiSessionManager.saveAuthToken(NHNApplication.instance, AppConfig.KEY_SENDING_ACCESS_TOKEN, newAuthToken)
                        ApiSessionManager.saveRefreshToken(NHNApplication.instance, newRefreshToken)

                        //Now, sending pending network request again
                        if (pendingRequest is ApiRequest<*>) {
                            pendingRequest.execute()

                        } else if (pendingRequest is MultipartRequest<*>) {
                            pendingRequest.execute()
                        }
                    }
                },
                {
                    if (pendingRequest is ApiRequest<*>) {
                        pendingRequest.mApiCallback?.onErrorResponse(ApiError(VolleyError()))

                    } else if (pendingRequest is MultipartRequest<*>) {
                        pendingRequest.mApiCallback?.onErrorResponse(ApiError(VolleyError()))
                    }
                })
    }

    private fun onSessionExpiration() {
        if (userRepository.isUupLoginProcessUpdatedMessageShown()) {
            MyToast.makeText(NHNApplication.instance, R.string.msg_session_expire_logout, Toast.LENGTH_LONG)
        }

        //In case refresh auth token API gives error after being executed on server then, logging out the app.
        LogoutUtil.doLogOut(NHNApplication.instance)
    }

}*/
