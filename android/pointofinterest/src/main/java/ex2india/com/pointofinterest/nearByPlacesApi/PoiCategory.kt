package ex2india.com.pointofinterest.nearByPlacesApi

enum class PoiCategory(val nhnCategoryName: String, val googlePlaceCategoryName: String) {
    POIEntertainment(
        "Entertainment",
        "amusement_park%7Cbowling_alley%7Cmovie_theater%7Cmuseum%7Czoo%7Cpark"
    ),
    POIRestaurant("Dining", "food%7Ccafe%7Crestaurant"),
    POISchool("Schools", "school%7Cuniversity"),
    POIGrocery("Grocery", "grocery_or_supermarket"),
    POIHospital("Hospitals", "hospital"),
    POIShopping(
        "Shopping",
        "clothing_store%7Cdepartment_store%7Celectronics_store%7Cshopping_mall"
    );
}