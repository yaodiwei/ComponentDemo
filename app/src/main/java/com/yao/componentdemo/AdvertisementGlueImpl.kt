package com.yao.componentdemo

import android.app.Activity
import android.content.Intent
import com.yao.lib_advertisement.IAdvertisementGlue
import com.yao.lib_user.LoginActivity
import com.yao.lib_user.UserManager

object AdvertisementGlueImpl: IAdvertisementGlue {

    override fun openLoginActivity(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    override fun loadUserConfig(): List<String> {
        return UserManager.currentUser?.channel ?: emptyList()
    }
}