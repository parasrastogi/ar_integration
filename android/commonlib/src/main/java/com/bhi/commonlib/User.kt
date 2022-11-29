package com.bhi.commonlib

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Holds user details.
 */
class User : Serializable {

    @SerializedName("BDXID")
    var bdxPartnerId = 0

    @SerializedName("PartnerID")
    var partnerId: Int = 0

    @SerializedName("UUPUserID")
    val uupUserId: String? = null

    @SerializedName("ID")
    var id: Int = 0

    @SerializedName("ProspectID")
    var prospectId: Int = 0

    @SerializedName("Email")
    var email: String? = null

    var isGuestUser: Boolean = false
}
