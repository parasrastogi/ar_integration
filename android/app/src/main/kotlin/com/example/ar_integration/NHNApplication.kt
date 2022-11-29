package com.example.ar_integration

import android.app.Application
import android.util.Log
import com.android.volley.Request
import com.bhi.commonlib.app.AppConfig
import com.example.ar_integration.core.ErrorLogger
import com.myvolley.listeners.ApiCallback
import com.myvolley.listeners.GlobalApiListener
import com.myvolley.managers.ApiManager
import com.myvolley.managers.ApiSessionManager
import com.myvolley.models.ApiError
import com.myvolley.models.NetworkResult
import com.myvolley.requests.ApiRequest
import com.myvolley.requests.multipart.MultipartRequest
import com.myvolley.util.ApiLogger

class NHNApplication : Application() {


    var authToken =
        "bearer L1vfLYoJIilVBXSs8BWJ1pkAnSNlx5d31qvR4aRTNYXj9L1Z-M3ahao2DQz12iytqlc5r-clfcup9Fm0yAWT6k8zzg_p5LzFglsjfkeboZwzneIJ_QlCgTdsoezDT_BytN8lvJ8xsKpikkELejFmG9gf_aWG3_EjslQRzqh5DBJnF4g1EK33dXDj49YknGjR6sAnQTq1VCmtU1tiM1a8T31BZfJw9FhBu1KbyIkchhsfk3YSlot_fODB1c_-NcR3_0C23khmmYCJwQFUiTNuN3XuJWS1R4jHp4TcZQjomjiO071VRTaTYXemJljvnFVedB_FXjFFfo8oNTaqB7lJ7tYZhlP598Oeayt8lt5KkVYszlJr-7ORyqwWHq5QUJ4cjabWvWf6caxcY7k-1yBQ2oTsVAEZ_IG8moap31Zen2Uty-iUaOtsA8tUusB2tnajS_tFPS-h1jONk_NSDvyBvl7W4iOg_AT4k99k4YsmuJh6vKHD1Ip_nBpxez9YyRz3L0-Bc2bkUSQgh-B0qasicrdfsthfJh_f6H68YswkOemKO1-IauQQEHy0szvGAi_r0plcfzFwazzmhwrR1Xkkr2zg3DjMbRjPhIWFvSRV_ea1Zc9bokEr1c3z3pAGja0z5ArrqWcqtVR-8cIngCdoAnXeMLS-K0Qw2dnegfn5ipjUqT6_ikgWxbudO8z7GKqKp1x7HBeiMVNHohr0zKowDnDzI0U"
    var refreshToken = ""
    override fun onCreate() {
        super.onCreate()
        val globalApiListener = object : GlobalApiListener {
            override fun onErrorResponse(request: Request<*>, error: ApiError) {
                if (request is ApiRequest<*>) {
                    if (error.networkResult?.statusCode == 401) {
                       // refreshAuthToken(request)
                    } else {
                        request.mApiCallback?.onErrorResponse(error)
                    }
                } else if (request is MultipartRequest) {
                    if (error.networkResult?.statusCode == 401) {
                      //  refreshAuthToken(request)
                    } else {
                        request.mApiCallback?.onErrorResponse(error)
                    }
                }
            }

            override fun onRequestPreExecute(
                request: Request<*>,
                onPreExecuteCompletion: () -> Unit
            ) {
                onPreExecuteCompletion()
            }

            override fun onResponse(
                request: Request<*>,
                response: Any?,
                networkResult: NetworkResult
            ) {
                if (request is ApiRequest<*>) {
                    (request.mApiCallback as ApiCallback<Any>?)?.onResponse(response, networkResult)

                } else if (request is MultipartRequest) {
                    (request.mApiCallback as ApiCallback<Any>?)?.onResponse(response, networkResult)
                }
            }
        }


        ApiManager.init(context = this, globalListener = globalApiListener)
        ApiLogger.isLogEnabled = true

        ApiSessionManager.saveAuthToken(this, AppConfig.KEY_SENDING_ACCESS_TOKEN, authToken)
        ApiSessionManager.saveRefreshToken(this, refreshToken)
        //Initializing API manager
        //   val errorLogger: ErrorLogger = FirebaseErrorLogger(FirebaseAnalytics.getInstance(instance))
//              val userRepository = UserRepository.getInstance(
//                  UserLocalDataSource.getInstance(),
//                  UserRemoteDataSource.getInstance()
//              )


    }
}
