package ex2india.com.pointofinterest.nearByPlacesApi

import com.bhi.commonlib.ApiHeader
import com.bhi.commonlib.Urls
import com.bhi.commonlib.nearByPlaces.NearByRadius
import com.bhi.commonlib.nearByPlaces.model.NearByPlaceResponse
import com.bhi.commonlib.repository.ErrorType
import com.google.android.gms.common.api.Response
import com.myvolley.listeners.ApiCallback
import com.myvolley.models.ApiError
import com.myvolley.models.NetworkResult
import com.myvolley.requests.ApiRequest

object NearByPlacesApiHelper {

    fun getNearByPlaces(latitude: Double, longitude: Double, type: String, radius: NearByRadius,
                        getNearByPlaceCallback: GetNearByPlaceCallback) {
       // val url = Urls.getNearPlacesUrl(latitude, longitude, type, radius)

        val apiRequest = ApiRequest<NearByPlaceResponse>(
                ApiRequest.GET, "https://salesarchitect-stage.exsquared.com/api/GoogleMaps/PlacesNearBySearch?latitude=28.3733895&longitude=77.3560641&radius=3&type=food%7Ccafe%7Crestaurant",
                null, NearByPlaceResponse::class.java, NearByPlacesApiCallback(getNearByPlaceCallback, type)
        )

        apiRequest.addHeader(ApiHeader.SA_API_VERSION, "2.0")
        apiRequest.execute()
    }

    private class NearByPlacesApiCallback(private val getNearByPlaceCallback: GetNearByPlaceCallback, private val type: String)
        : ApiCallback<NearByPlaceResponse>() {

        override fun onResponse(response: NearByPlaceResponse?, networkResult: NetworkResult) {
            super.onResponse(response, networkResult)
            if (response != null) {
                getNearByPlaceCallback.onNearByPlaceReceiveSuccess(response)
            } else {
                getNearByPlaceCallback.onNearByPlaceReceiveFailure(Exception(ErrorType.OTHER.name))
            }
        }

        override fun onErrorResponse(error: ApiError) {
            super.onErrorResponse(error)
            getNearByPlaceCallback.onNearByPlaceReceiveFailure(error)
        }
    }
}
