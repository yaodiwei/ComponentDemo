package com.yao.lib_advertisement

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.yao.lib_base.UserDaggerService
import javax.inject.Inject
import javax.inject.Singleton

class UserDaggerServiceImpl : UserDaggerService{

    override fun openLoginActivity(activity: Activity) {
        Toast.makeText(activity, "can't open", Toast.LENGTH_SHORT).show()
    }

    override fun loadUserConfig(): List<String> {
        return emptyList()
    }

}