package com.yao.componentdemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_advertisement.AdvertisementServiceInAd
import com.yao.lib_base.RouterHub
import com.yao.lib_user.LoginActivity
import com.yao.lib_user.UserManager

@Route(path = RouterHub.ADVERTISEMENT_SERVICE_IN_AD, name = "在Ad模块声明的广告服务")
class AdvertisementServiceInAdImpl: AdvertisementServiceInAd {

    override fun init(context: Context?) {
        Log.e("YAO", "AdvertisementServiceInBaseImpl init")
    }

    override fun openLoginActivity(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    override fun loadUserConfig(): List<String> {
        return UserManager.currentUser?.channel ?: emptyList()
    }

}