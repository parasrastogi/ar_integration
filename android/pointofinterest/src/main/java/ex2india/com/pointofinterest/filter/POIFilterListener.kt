package ex2india.com.pointofinterest.filter

import ex2india.com.pointofinterest.nearByPlacesApi.PoiCategory
import ex2india.com.pointofinterest.radius.Radius

interface POIFilterListener {

    fun onCategorySelected(category: PoiCategory)

    fun onRadiusSelected(radius: Radius)
}
