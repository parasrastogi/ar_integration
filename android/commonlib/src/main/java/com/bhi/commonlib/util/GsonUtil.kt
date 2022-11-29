package com.bhi.commonlib.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type

/**
 * @author Rahul Rastogi.
 *
 * Provides Json serialization and de-serialization methods.
 */
object GsonUtil {

    fun <T> fromJson(json: String?, type: Type): T? {
        return try {
            if (null == json) {
                null
            } else {
                Gson().fromJson<T>(json, type)
            }
        } catch (ex: JsonSyntaxException) {
            //ex.printStackTrace()
            null
        }
    }


    fun <T> toJson(data: T, serializeNulls: Boolean = true): String {
        return if (serializeNulls) {
            GsonBuilder().serializeNulls().create().toJson(data)
        } else {
            GsonBuilder().create().toJson(data)
        }
    }


    fun <T> toJsonObject(data: T, serializeNulls: Boolean = true): JsonObject {
        return if (serializeNulls) {
            GsonBuilder().serializeNulls().create().toJsonTree(data).asJsonObject
        } else {
            GsonBuilder().create().toJsonTree(data).asJsonObject
        }
    }
}
