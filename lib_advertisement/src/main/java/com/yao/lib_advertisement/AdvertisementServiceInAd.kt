package com.yao.lib_advertisement

import android.app.Activity
import com.alibaba.android.arouter.facade.template.IProvider

interface AdvertisementServiceInAd: IProvider {

    fun openLoginActivity(activity: Activity)

    fun loadUserConfig(): List<String>
}