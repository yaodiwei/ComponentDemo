package com.yao.lib_base

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * @author Yao
 * @date 2020/01/21
 */
object GsonUtil {

    private const val TAG = "GsonUtil"
    private val GSON = Gson()

    @JvmStatic
    fun toJson(obj: Any?): String {
        if (obj != null) {
            try {
                return GSON.toJson(obj)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
        return ""
    }

    fun <T> fromJson(jsonStr: String?, clazz: Class<T>?): T? {
        var jsonObj: T? = null
        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                jsonObj = GSON.fromJson(jsonStr, clazz)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
        return jsonObj
    }

    @JvmStatic
    fun <T> fromJson(jsonStr: String?, typeOfT: Type?): T? {
        var jsonObj: T? = null
        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                jsonObj = GSON.fromJson(jsonStr, typeOfT)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
        return jsonObj
    }
}