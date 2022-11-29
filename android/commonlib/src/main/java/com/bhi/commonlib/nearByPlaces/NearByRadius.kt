package com.bhi.commonlib.nearByPlaces

enum class NearByRadius(val apiValue: Int, val miles: Int, val distanceInMetres: Int) {
    ONE(1, 1, 1604),
    TWO(2, 5,8020),
    THREE(3, 10,16040),
    FOUR(4, 20,32080),
    FIVE(5, 3,5000),
    SIX(6, 9,15000)
}