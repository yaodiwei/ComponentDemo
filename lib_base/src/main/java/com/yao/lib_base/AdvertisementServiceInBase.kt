package com.yao.lib_base

import android.app.Activity
import com.alibaba.android.arouter.facade.template.IProvider

interface AdvertisementServiceInBase: IProvider {

    fun openLoginActivity(activity: Activity)

    fun loadUserConfig(): List<String>
}