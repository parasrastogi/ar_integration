package ex2india.com.pointofinterest.nearByPlacesApi

import com.bhi.commonlib.nearByPlaces.model.NearByPlaceResponse

interface GetNearByPlaceCallback {
    fun onNearByPlaceReceiveSuccess(nearByPlaceResponse: NearByPlaceResponse)
    fun onNearByPlaceReceiveFailure(exception: Exception)
}