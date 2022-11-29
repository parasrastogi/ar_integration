package com.bhi.commonlib

import android.text.TextUtils
import com.bhi.commonlib.BuildConfig.BASE_NHS_ODE_API_URL
import com.bhi.commonlib.nearByPlaces.NearByRadius

/**
 * Holds all web API urls.
 */
object Urls {

    private lateinit var BASE_PORTAL_URL: String

    private const val BASE_URL = BuildConfig.BASE_URL
    const val BASE_MY_PHOTO_URL = "$BASE_URL/ProspectAsset/GetImage"

    /**
     * This method must be called before using Urls class.
     */
    fun init(basePortalUrl: String) {
        BASE_PORTAL_URL = basePortalUrl
    }

    val AUTH_VIA_UUP = Url("$BASE_URL/api/Consumer/LoginWithUUP", ApiVersion.V2)

    val GUEST_SIGN_UP = Url("$BASE_URL/api/Consumer/register", ApiVersion.V2)

    val CHANGE_PASSWORD = Url("$BASE_URL/api/account/ChangePasswordWithUUP", ApiVersion.V2)

    val GET_USER_PROFILE = Url("$BASE_URL/api/Account/GetUserUUPProfile", ApiVersion.V2)

    val UPDATE_USER_PROFILE = Url("$BASE_URL/api/account/EditProfileWithUUP", ApiVersion.V2)

    val UPDATE_LAST_LOGON_DATE = Url("$BASE_URL/api/Account/UpdateUserLastLogon", ApiVersion.V2)

    val COMMUNITY_LIST = Url(
        "$BASE_URL/api/communitylisting/GetMyCommunities?${UrlParam.INCLUDE_MPC}=true",
        ApiVersion.V2
    )

    val COMMUNITY_VIDEO =
        Url("$BASE_URL/api/communitylisting/getcommunityvideos?bdxcommunityid=%s", ApiVersion.V2)

    val UPDATE_COMMUNITY_PROSPECT =
        Url("$BASE_URL/api/ProspectCommunity/UpdateNotes", ApiVersion.V2)

    private val RESOURCE_CENTER =
        Url("$BASE_URL/api/Configuration/GetResourceCenterLinks", ApiVersion.V2)

    val PARTNER_CONFIGURATION =
        Url("$BASE_URL/api/Configuration/GetPartnerDetail?partnerNames=", ApiVersion.V2)

    val ADD_PROSPECT_PLAN_LISTING = Url("$BASE_URL/api/prospectlisting/add", ApiVersion.V2)

    val DELETE_PROSPECT_PLAN_LISTING = Url("$BASE_URL/api/prospectlisting/delete", ApiVersion.V2)

    val ADD_PROSPECT_ASSET = Url("$BASE_URL/api/prospectasset/add", ApiVersion.V2)

    val DELETE_PROSPECT_ASSET = Url("$BASE_URL/api/ProspectAsset/DeleteMultiple", ApiVersion.V2)

    val ADD_REMOVE_FAV_LOT =
        Url("$BASE_URL/api/ConsumerProspect/AddRemoveProspectLot", ApiVersion.V2)

    val EVENT_LOGGER = Url("$BASE_NHS_ODE_API_URL/api/v2/Log/EventLogger", ApiVersion.V2)

    val REFRESH_TOKEN = Url("$BASE_URL/api/Consumer/RefreshToken", ApiVersion.V2)

    val SAVE_PUSH_TOKEN = Url("$BASE_URL/api/account/AddDeviceToken", ApiVersion.V2)

    val GET_MARKETS = Url("$BASE_URL/api/communitylisting/GetMarkets", ApiVersion.V2)

    val REQUEST_INFO = Url("$BASE_URL/api/ProspectLead/RequestInfo", ApiVersion.V2)

    val GET_PROSPECT_LOT = Url("$BASE_URL/api/consumerprospect/GetProspectLotData", ApiVersion.V2)

    val GET_FEEDBACK_CATEGORIES =
        Url("$BASE_URL/api/Configuration/GetFeedbackCategories", ApiVersion.V2)

    val SAVE_FEEDBACK = Url("$BASE_URL/api/Configuration/SaveFeedback", ApiVersion.V2)

    val GET_COMMUNITIES = Url("$BASE_URL/api/CommunityListing/GetCommunities", ApiVersion.V2)

    val GET_HOMES = Url("$BASE_URL/api/CommunityListing/GetHomes", ApiVersion.V2)

    val GET_BUILDERS = Url("$BASE_URL/api/CommunityListing/GetBuilders", ApiVersion.V2)

    val GET_FILTER_OPTIONS = Url("$BASE_URL/api/CommunityListing/GetFilterOptions", ApiVersion.V2)

    val SAVE_NOTIFICATION_TAP =
        Url("$BASE_URL/api/PushNotification/SetNotificationTapped", ApiVersion.V2)

    val TRUST_BUILDER_AREAS = Url("$BASE_URL/api/ReviewsRating/GetTrustBuilderAreas", ApiVersion.V2)

    val CDP_SYNC_DATA_URL = Url("$BASE_URL/api/ConsumerProspect/SyncCDPIdentifyData", ApiVersion.V2)

    fun getConsumerProspectUrl(cdpEventName: String?): Url {
        val urlBuilder = StringBuilder()
        urlBuilder.append("$BASE_URL/api/consumerprospect/GetProspectPackage?${UrlParam.INCLUDE_MPC}=true")
        if (!TextUtils.isEmpty(cdpEventName)) {
            urlBuilder.append("&${UrlParam.CDP_Event}=$cdpEventName")
        }
        return Url(urlBuilder.toString(), ApiVersion.V2)
    }

    fun getUupUserSearchUrl(orgID: Int, email: String): Url {
        return Url(
            "${BuildConfig.BDX_AUTH_API_BASE_URL}/api/User/CheckEmail?orgID=$orgID&userEmail=$email",
            ApiVersion.NO_VERSION
        )
    }

    fun getResourceCenterUrl(internalPartnerId: Int): Url {
        return Url("${RESOURCE_CENTER.url}?partnerId=$internalPartnerId", ApiVersion.V2)
    }

    fun getAddCommunityUrl(
        bdxCommunityCode: String,
        source: Int,
        isBuilderBrandedApp: Boolean
    ): Url {
        return Url(
            "$BASE_URL/api/ConsumerCommunity/AddCommunity?${UrlParam.INCLUDE_MPC}=true&bdxCommunityCode=$bdxCommunityCode&isBuilderBrandedApp=$isBuilderBrandedApp&AddSource=$source",
            ApiVersion.V2
        )
    }

    fun getRatingDetailUrl(appVersion: String): Url {
        return Url(
            "$BASE_URL/api/Configuration/GetAppRatingDetails?appVersion=$appVersion",
            ApiVersion.V2
        )
    }

    fun saveRatingDetailUrl(appVersion: String, ratingStatus: Int): Url {
        return Url(
            "$BASE_URL/api/Configuration/SaveAppRatingDetails?appVersion=$appVersion&ratingStatus=$ratingStatus",
            ApiVersion.V2
        )
    }

    fun getCommunityByBuilderIdUrl(builderId: Int, marketId: Int) = Url(
        "$BASE_URL/api/communitylisting/getcommunitiesbybuilderid?${UrlParam.INCLUDE_MPC}=true&builderid=$builderId&marketid=$marketId",
        ApiVersion.V2
    )

    fun getPlacesAutoCompleteUrl(searchText: String, latLngString: String, sessionToken: String) =
        Url(
            "$BASE_URL/api/GoogleMaps/PlacesAutoComplete?searchText=$searchText&sessionToken=$sessionToken&origin=$latLngString",
            ApiVersion.V2
        )

    fun getPlaceDetailUrl(placeId: String, sessionToken: String) = Url(
        "$BASE_URL/api/GoogleMaps/PlacesDetail?placeId=$placeId&sessionToken=$sessionToken",
        ApiVersion.V2
    )

    fun getBuilderByMarketIdUrl(marketId: Int) = Url(
        "$BASE_URL/api/communitylisting/getbuilderbylocation?${UrlParam.INCLUDE_MPC}=true&marketid=$marketId",
        ApiVersion.V2
    )

    fun getBuilderByLatLngAndRadiusUrl(latitude: Double, longitude: Double, radius: Int) = Url(
        "$BASE_URL/api/communitylisting/getbuilderbylocation?${UrlParam.INCLUDE_MPC}=true&radius=$radius&originLat=$latitude&originlng=$longitude",
        ApiVersion.V2
    )

    fun getPlanDetailUrl(bdxPlanId: Int, isSpec: Boolean) = Url(
        "$BASE_URL/api/CommunityListing/GetListingDetail?bdxListingid=$bdxPlanId&isSpec=$isSpec",
        ApiVersion.V2
    )

    fun getCommunityDetailUrl(communityId: Int?, bdxCommunityId: Int?): Url {
        return Url(
            "$BASE_URL/api/CommunityListing/GetCommunityDetail?${UrlParam.INCLUDE_MPC}=true&communityID=$communityId&bdxcommunityid=$bdxCommunityId",
            ApiVersion.V2
        )
    }

    fun getNearPlacesUrl(
        latitude: Double,
        longitude: Double,
        type: String,
        radius: NearByRadius
    ): Url {
        return Url(
            "$BASE_URL/api/GoogleMaps/PlacesNearBySearch?" +
                    "latitude=$latitude" +
                    "&longitude=$longitude" +
                    "&radius=${radius.apiValue}" +
                    "&type=$type",
            ApiVersion.V2
        )
    }

    fun getMasterPlanUrl(communityId: Int, masterPlanId: Int?): Url {
        return Url(
            "$BASE_URL/SiteMapPreview/MasterSitePlan?communityID=$communityId&masterSiteID=$masterPlanId",
            ApiVersion.V2
        )
    }

    fun getBuilderConfigurationUrl(partnerName: String): Url {
        return Url(PARTNER_CONFIGURATION.url + partnerName, ApiVersion.V2)
    }

    fun getAvailableLotsUrl(communityId: Int, bdxListingId: Int): Url {
        return Url(
            "$BASE_URL/api/communitylisting/GetAvailableLotDetails?communityid=$communityId&bdxlistingid=$bdxListingId",
            ApiVersion.V2
        )
    }

    fun getTermsOfUseUrl(partnerName: String) =
        "$BASE_PORTAL_URL/TermsofUse/v2?PartnerName=$partnerName"

    fun getPrivacyPolicyUrl() = "${BuildConfig.BASE_NHS_WEB_URL}/privacypolicy"

    fun getSvgUrl(siteId: Int, version: String?): Url {
        return if (TextUtils.isEmpty(version)) {
            Url("$BASE_URL/api/Sitemap/GetBySiteId?siteId=$siteId", ApiVersion.V2)
        } else {
            Url("$BASE_URL/api/Sitemap/GetBySiteId?siteId=$siteId&version=$version", ApiVersion.V2)
        }
    }

    fun getTypeAheadUrl(
        searchText: String,
        type: String,
        startsWith: Boolean = true, sortBy: String = "communityCount"
    ): Url {
        return Url(
            "$BASE_URL/api/TypeAhead?searchTerm=$searchText&types=$type&startswith=$startsWith&sortBy=$sortBy",
            ApiVersion.V2
        )
    }

    fun getBrandDetailUrl(brandId: Int) =
        Url("$BASE_URL/api/Brands/GetBrandShowcase?BrandId=$brandId", ApiVersion.V2)

    fun getBrandReviewsUrl(
        brandId: Int,
        pageSize: Int,
        page: Int,
        marketId: Int? = null,
        sortBy: Int? = null
    ): Url {
        val urlStringBuilder = StringBuilder()
        urlStringBuilder.append("$BASE_URL/api/Brands/GetBrandReviewsData?BrandId=$brandId&Page=$page&PageSize=$pageSize")
        if (marketId != null) {
            urlStringBuilder.append("&MarketId=$marketId")
        }
        if (sortBy != null) {
            urlStringBuilder.append("&SortBy=$sortBy")
        }
        return Url(urlStringBuilder.toString(), ApiVersion.V2)
    }

    fun getSaveProspectBrandUrl(brandId: Int, includeMPC: Boolean, addSource: Int): Url {
        val urlStringBuilder =
            StringBuilder("$BASE_URL/api/ProspectBuilder/AddFavouriteProspect?bdxBrandID=$brandId")
        urlStringBuilder.append("&${UrlParam.INCLUDE_MPC}=$includeMPC")
        urlStringBuilder.append("&addSource=$addSource")
        return Url(urlStringBuilder.toString(), ApiVersion.V2)
    }

    fun getDeleteProspectBrandUrl(brandId: Int) = Url(
        "$BASE_URL/api/ProspectBuilder/DeleteFavouriteProspect?bdxBrandID=$brandId",
        ApiVersion.V2
    )

    fun getPreApprovedUrl(preApprovedExternal: PreApprovedExternal): String {
        return "https://widgets.icanbuy.com/c/standard/us/en/mortgage/widgets/nhs/widgets" +
                "/leadfunnel/LeadFunnel.aspx?siteid=206f35c4e7ee1a32&channelid=19190&accountid=43866" +
                "&external=${preApprovedExternal.value}"
    }

    fun getTrustBuilderBrandsUrl(
        pageSize: Int,
        pageNumber: Int,
        marketId: Int? = null,
        brandId: Int? = null
    ): Url {
        val url =
            "$BASE_URL/api/ReviewsRating/GetTrustBuilderBrands?pageSize=$pageSize&page=$pageNumber"
                .appendUrlParams("marketId", marketId)
                .appendUrlParams(
                    "brands", if (brandId != null) {
                        listOf(brandId).joinToString(",")
                    } else {
                        null
                    }
                )
        return Url(url, ApiVersion.V2)
    }

    private fun String.appendUrlParams(key: String, value: Any?): String {
        return if (value != null) {
            "$this&$key=$value"
        } else {
            this
        }
    }
}
