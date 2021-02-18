package com.yao.lib_advertisement

import android.app.Activity
import java.util.*

object AdvertisementGlue {

    var advertisement: IAdvertisementGlue? = null

    fun openLoginActivity(activity: Activity) {
        advertisement?.openLoginActivity(activity)
    }

    fun loadUserConfig(): List<String> {
        return advertisement?.let {
            advertisement?.loadUserConfig()
        } ?: Collections.emptyList()
    }
}

interface IAdvertisementGlue {

    fun openLoginActivity(activity: Activity)

    fun loadUserConfig(): List<String>
}