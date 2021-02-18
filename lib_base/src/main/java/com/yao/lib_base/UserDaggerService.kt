package com.yao.lib_base

import android.app.Activity

interface UserDaggerService {

    fun openLoginActivity(activity: Activity)

    fun loadUserConfig(): List<String>
}
