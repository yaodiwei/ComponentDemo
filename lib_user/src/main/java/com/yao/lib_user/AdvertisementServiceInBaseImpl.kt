package com.yao.lib_user

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_base.AdvertisementServiceInBase
import com.yao.lib_base.RouterHub

@Route(path = RouterHub.ADVERTISEMENT_SERVICE_IN_BASE, name = "在Base模块声明的广告服务")
class AdvertisementServiceInBaseImpl : AdvertisementServiceInBase {

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