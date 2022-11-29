package com.bhi.commonlib;

import java.lang.System;

/**
 * Holds all web API urls.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b:\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020I2\u0006\u0010N\u001a\u00020IJ\u000e\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020IJ;\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020I2\u0006\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020I2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010I\u00a2\u0006\u0002\u0010VJ\u001e\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020IJ\u000e\u0010\\\u001a\u00020\u00042\u0006\u0010T\u001a\u00020IJ\u000e\u0010]\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u000eJ\u0016\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020I2\u0006\u0010T\u001a\u00020IJ\u001f\u0010a\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010I2\b\u0010b\u001a\u0004\u0018\u00010I\u00a2\u0006\u0002\u0010cJ\u0010\u0010d\u001a\u00020\u00042\b\u0010e\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010f\u001a\u00020\u00042\u0006\u0010P\u001a\u00020IJ\u001d\u0010g\u001a\u00020\u00042\u0006\u0010M\u001a\u00020I2\b\u0010h\u001a\u0004\u0018\u00010I\u00a2\u0006\u0002\u0010iJ&\u0010j\u001a\u00020\u00042\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010k\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020lJ\u0016\u0010m\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020\u000eJ\u001e\u0010p\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020\u000eJ\u0016\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020I2\u0006\u0010u\u001a\u00020KJ\u000e\u0010v\u001a\u00020\u000e2\u0006\u0010w\u001a\u00020xJ\u0006\u0010y\u001a\u00020\u000eJ\u000e\u0010z\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u000eJ\u000e\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020IJ\u001f\u0010~\u001a\u00020\u00042\u0006\u0010P\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020K2\u0007\u0010\u0080\u0001\u001a\u00020IJ\u001b\u0010\u0081\u0001\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020I2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000eJ\u000f\u0010\u0084\u0001\u001a\u00020\u000e2\u0006\u0010^\u001a\u00020\u000eJ6\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010R\u001a\u00020I2\u0007\u0010\u0086\u0001\u001a\u00020I2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010I\u00a2\u0006\u0003\u0010\u0087\u0001J,\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010k\u001a\u00020\u000e2\t\b\u0002\u0010\u0089\u0001\u001a\u00020K2\b\b\u0002\u0010U\u001a\u00020\u000eJ\u0019\u0010\u008a\u0001\u001a\u00020\u00042\u0007\u0010\u008b\u0001\u001a\u00020I2\u0007\u0010\u008c\u0001\u001a\u00020\u000eJ\u0011\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u000eJ\u0018\u0010\u0090\u0001\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u000e2\u0007\u0010\u0091\u0001\u001a\u00020IJ!\u0010\u0092\u0001\u001a\u00020\u000e*\u00020\u000e2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010\'\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0011\u00101\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0011\u00103\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u000e\u00107\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00108\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0011\u0010>\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0011\u0010@\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0011\u0010B\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0011\u0010D\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006\u00a8\u0006\u0095\u0001"}, d2 = {"Lcom/bhi/commonlib/Urls;", "", "()V", "ADD_PROSPECT_ASSET", "Lcom/bhi/commonlib/Url;", "getADD_PROSPECT_ASSET", "()Lcom/bhi/commonlib/Url;", "ADD_PROSPECT_PLAN_LISTING", "getADD_PROSPECT_PLAN_LISTING", "ADD_REMOVE_FAV_LOT", "getADD_REMOVE_FAV_LOT", "AUTH_VIA_UUP", "getAUTH_VIA_UUP", "BASE_MY_PHOTO_URL", "", "BASE_PORTAL_URL", "BASE_URL", "CDP_SYNC_DATA_URL", "getCDP_SYNC_DATA_URL", "CHANGE_PASSWORD", "getCHANGE_PASSWORD", "COMMUNITY_LIST", "getCOMMUNITY_LIST", "COMMUNITY_VIDEO", "getCOMMUNITY_VIDEO", "DELETE_PROSPECT_ASSET", "getDELETE_PROSPECT_ASSET", "DELETE_PROSPECT_PLAN_LISTING", "getDELETE_PROSPECT_PLAN_LISTING", "EVENT_LOGGER", "getEVENT_LOGGER", "GET_BUILDERS", "getGET_BUILDERS", "GET_COMMUNITIES", "getGET_COMMUNITIES", "GET_FEEDBACK_CATEGORIES", "getGET_FEEDBACK_CATEGORIES", "GET_FILTER_OPTIONS", "getGET_FILTER_OPTIONS", "GET_HOMES", "getGET_HOMES", "GET_MARKETS", "getGET_MARKETS", "GET_PROSPECT_LOT", "getGET_PROSPECT_LOT", "GET_USER_PROFILE", "getGET_USER_PROFILE", "GUEST_SIGN_UP", "getGUEST_SIGN_UP", "PARTNER_CONFIGURATION", "getPARTNER_CONFIGURATION", "REFRESH_TOKEN", "getREFRESH_TOKEN", "REQUEST_INFO", "getREQUEST_INFO", "RESOURCE_CENTER", "SAVE_FEEDBACK", "getSAVE_FEEDBACK", "SAVE_NOTIFICATION_TAP", "getSAVE_NOTIFICATION_TAP", "SAVE_PUSH_TOKEN", "getSAVE_PUSH_TOKEN", "TRUST_BUILDER_AREAS", "getTRUST_BUILDER_AREAS", "UPDATE_COMMUNITY_PROSPECT", "getUPDATE_COMMUNITY_PROSPECT", "UPDATE_LAST_LOGON_DATE", "getUPDATE_LAST_LOGON_DATE", "UPDATE_USER_PROFILE", "getUPDATE_USER_PROFILE", "getAddCommunityUrl", "bdxCommunityCode", "source", "", "isBuilderBrandedApp", "", "getAvailableLotsUrl", "communityId", "bdxListingId", "getBrandDetailUrl", "brandId", "getBrandReviewsUrl", "pageSize", "page", "marketId", "sortBy", "(IIILjava/lang/Integer;Ljava/lang/Integer;)Lcom/bhi/commonlib/Url;", "getBuilderByLatLngAndRadiusUrl", "latitude", "", "longitude", "radius", "getBuilderByMarketIdUrl", "getBuilderConfigurationUrl", "partnerName", "getCommunityByBuilderIdUrl", "builderId", "getCommunityDetailUrl", "bdxCommunityId", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bhi/commonlib/Url;", "getConsumerProspectUrl", "cdpEventName", "getDeleteProspectBrandUrl", "getMasterPlanUrl", "masterPlanId", "(ILjava/lang/Integer;)Lcom/bhi/commonlib/Url;", "getNearPlacesUrl", "type", "Lcom/bhi/commonlib/nearByPlaces/NearByRadius;", "getPlaceDetailUrl", "placeId", "sessionToken", "getPlacesAutoCompleteUrl", "searchText", "latLngString", "getPlanDetailUrl", "bdxPlanId", "isSpec", "getPreApprovedUrl", "preApprovedExternal", "Lcom/bhi/commonlib/PreApprovedExternal;", "getPrivacyPolicyUrl", "getRatingDetailUrl", "appVersion", "getResourceCenterUrl", "internalPartnerId", "getSaveProspectBrandUrl", "includeMPC", "addSource", "getSvgUrl", "siteId", "version", "getTermsOfUseUrl", "getTrustBuilderBrandsUrl", "pageNumber", "(IILjava/lang/Integer;Ljava/lang/Integer;)Lcom/bhi/commonlib/Url;", "getTypeAheadUrl", "startsWith", "getUupUserSearchUrl", "orgID", "email", "init", "", "basePortalUrl", "saveRatingDetailUrl", "ratingStatus", "appendUrlParams", "key", "value", "commonlib_stage"})
public final class Urls {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.Urls INSTANCE = null;
    private static java.lang.String BASE_PORTAL_URL;
    private static final java.lang.String BASE_URL = "https://salesarchitect-stage.exsquared.com";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_MY_PHOTO_URL = "https://salesarchitect-stage.exsquared.com/ProspectAsset/GetImage";
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url AUTH_VIA_UUP = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GUEST_SIGN_UP = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url CHANGE_PASSWORD = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_USER_PROFILE = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url UPDATE_USER_PROFILE = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url UPDATE_LAST_LOGON_DATE = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url COMMUNITY_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url COMMUNITY_VIDEO = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url UPDATE_COMMUNITY_PROSPECT = null;
    private static final com.bhi.commonlib.Url RESOURCE_CENTER = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url PARTNER_CONFIGURATION = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url ADD_PROSPECT_PLAN_LISTING = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url DELETE_PROSPECT_PLAN_LISTING = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url ADD_PROSPECT_ASSET = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url DELETE_PROSPECT_ASSET = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url ADD_REMOVE_FAV_LOT = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url EVENT_LOGGER = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url REFRESH_TOKEN = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url SAVE_PUSH_TOKEN = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_MARKETS = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url REQUEST_INFO = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_PROSPECT_LOT = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_FEEDBACK_CATEGORIES = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url SAVE_FEEDBACK = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_COMMUNITIES = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_HOMES = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_BUILDERS = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url GET_FILTER_OPTIONS = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url SAVE_NOTIFICATION_TAP = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url TRUST_BUILDER_AREAS = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.Url CDP_SYNC_DATA_URL = null;
    
    private Urls() {
        super();
    }
    
    /**
     * This method must be called before using Urls class.
     */
    public final void init(@org.jetbrains.annotations.NotNull()
    java.lang.String basePortalUrl) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getAUTH_VIA_UUP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGUEST_SIGN_UP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCHANGE_PASSWORD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_USER_PROFILE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getUPDATE_USER_PROFILE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getUPDATE_LAST_LOGON_DATE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCOMMUNITY_LIST() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCOMMUNITY_VIDEO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getUPDATE_COMMUNITY_PROSPECT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getPARTNER_CONFIGURATION() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getADD_PROSPECT_PLAN_LISTING() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getDELETE_PROSPECT_PLAN_LISTING() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getADD_PROSPECT_ASSET() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getDELETE_PROSPECT_ASSET() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getADD_REMOVE_FAV_LOT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getEVENT_LOGGER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getREFRESH_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getSAVE_PUSH_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_MARKETS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getREQUEST_INFO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_PROSPECT_LOT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_FEEDBACK_CATEGORIES() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getSAVE_FEEDBACK() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_COMMUNITIES() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_HOMES() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_BUILDERS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getGET_FILTER_OPTIONS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getSAVE_NOTIFICATION_TAP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getTRUST_BUILDER_AREAS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCDP_SYNC_DATA_URL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getConsumerProspectUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String cdpEventName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getUupUserSearchUrl(int orgID, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getResourceCenterUrl(int internalPartnerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getAddCommunityUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String bdxCommunityCode, int source, boolean isBuilderBrandedApp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getRatingDetailUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String appVersion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url saveRatingDetailUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String appVersion, int ratingStatus) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCommunityByBuilderIdUrl(int builderId, int marketId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getPlacesAutoCompleteUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String searchText, @org.jetbrains.annotations.NotNull()
    java.lang.String latLngString, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getPlaceDetailUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId, @org.jetbrains.annotations.NotNull()
    java.lang.String sessionToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getBuilderByMarketIdUrl(int marketId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getBuilderByLatLngAndRadiusUrl(double latitude, double longitude, int radius) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getPlanDetailUrl(int bdxPlanId, boolean isSpec) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getCommunityDetailUrl(@org.jetbrains.annotations.Nullable()
    java.lang.Integer communityId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer bdxCommunityId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getNearPlacesUrl(double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.nearByPlaces.NearByRadius radius) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getMasterPlanUrl(int communityId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer masterPlanId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getBuilderConfigurationUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String partnerName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getAvailableLotsUrl(int communityId, int bdxListingId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTermsOfUseUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String partnerName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrivacyPolicyUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getSvgUrl(int siteId, @org.jetbrains.annotations.Nullable()
    java.lang.String version) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getTypeAheadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String searchText, @org.jetbrains.annotations.NotNull()
    java.lang.String type, boolean startsWith, @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getBrandDetailUrl(int brandId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getBrandReviewsUrl(int brandId, int pageSize, int page, @org.jetbrains.annotations.Nullable()
    java.lang.Integer marketId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sortBy) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getSaveProspectBrandUrl(int brandId, boolean includeMPC, int addSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getDeleteProspectBrandUrl(int brandId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPreApprovedUrl(@org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.PreApprovedExternal preApprovedExternal) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Url getTrustBuilderBrandsUrl(int pageSize, int pageNumber, @org.jetbrains.annotations.Nullable()
    java.lang.Integer marketId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId) {
        return null;
    }
    
    private final java.lang.String appendUrlParams(java.lang.String $this$appendUrlParams, java.lang.String key, java.lang.Object value) {
        return null;
    }
}