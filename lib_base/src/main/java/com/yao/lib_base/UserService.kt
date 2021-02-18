package com.yao.lib_base

import android.app.Activity
import com.alibaba.android.arouter.facade.template.IProvider
import io.reactivex.Observable
import io.reactivex.Single

interface UserService: IProvider {

    fun openLoginActivity(activity: Activity)

    fun loadUserConfig(): List<String>

    fun getVipLevel(): Int

    fun openVipActivity(activity: Activity)

    // 观察者模式回调
    fun registerUserInfoUpdate(callback: UserInfoUpdateCallback)

    // 网络请求式异步
    fun requestUserInfoUpdate(): Observable<String>
}


interface UserInfoUpdateCallback {
    fun onUserInfoUpdate(jsonString: String)
}