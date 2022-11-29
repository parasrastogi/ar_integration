package ex2india.com.pointofinterest

import android.content.Context
import androidx.annotation.StringRes
import com.android.volley.NetworkError
import com.android.volley.NoConnectionError
import com.android.volley.TimeoutError
import com.android.volley.VolleyError
import com.bhi.commonlib.util.MyToast
import com.myvolley.models.ApiError

/**
 * @author Rahul Rastogi
 *
 * Provides API error related message from Throwable object received on API error.
 */
internal object ApiErrorMessage {

    @StringRes
    fun getErrorMessageRes(apiError: ApiError?): Int {
        return if (apiError?.errorType == ApiError.NO_CONNECTION_ERROR) {
            R.string.msg_no_network
        } else if (apiError?.errorType == ApiError.TIMEOUT_ERROR || apiError?.errorType == ApiError.NETWORK_ERROR) {
            R.string.msg_timeout
        } else {
            R.string.msg_something_went_wrong
        }
    }

    @StringRes
    fun getErrorMessageRes(volleyError: VolleyError?): Int {
        return if (volleyError is NoConnectionError) {
            R.string.msg_no_network
        } else if (volleyError is TimeoutError || volleyError is NetworkError) {
            R.string.msg_timeout
        } else {
            R.string.msg_something_went_wrong
        }
    }

    fun showToast(context: Context, apiError: ApiError?) {
        MyToast.makeText(context, getErrorMessageRes(apiError))
    }

    fun showToast(context: Context, volleyError: VolleyError?) {
        MyToast.makeText(context, getErrorMessageRes(volleyError))
    }
}
