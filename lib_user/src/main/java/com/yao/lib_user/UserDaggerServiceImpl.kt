package com.yao.lib_user

import android.app.Activity
import android.content.Intent
import com.yao.lib_base.UserDaggerService
import javax.inject.Inject
import javax.inject.Singleton

//class UserDaggerServiceImpl @Inject constructor() : UserDaggerService {
//
//    override fun openLoginActivity(activity: Activity) {
//        activity.startActivity(Intent(activity, LoginActivity::class.java))
//    }
//
//    override fun loadUserConfig(): List<String> {
//        return UserManager.currentUser?.channel ?: emptyList()
//    }
//
//}