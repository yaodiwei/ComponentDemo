package com.yao.lib_user

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_base.GsonUtil
import com.yao.lib_base.RouterHub
import com.yao.lib_base.UserInfoUpdateCallback
import com.yao.lib_base.UserService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.internal.operators.flowable.FlowableReplay.observeOn
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@Route(path = RouterHub.USER_SERVER, name = "lib_user模块提供出来的服务")
class UserServiceImpl : UserService {

    private val userInfoUpdateCallbackList = mutableListOf<UserInfoUpdateCallback>()

    override fun init(context: Context?) {
        Log.e("YAO", "UserServiceImpl init")
    }

    override fun openLoginActivity(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    override fun loadUserConfig(): List<String> {
        return UserManager.currentUser?.channel ?: emptyList()
    }

    override fun getVipLevel(): Int {
        return UserManager.currentUser?.vipLevel ?: 0
    }

    override fun openVipActivity(activity: Activity) {
        activity.startActivity(Intent(activity, VipActivity::class.java))
    }

    @SuppressLint("CheckResult")
    override fun registerUserInfoUpdate(callback: UserInfoUpdateCallback) {
        if (!userInfoUpdateCallbackList.contains(callback)) {
            userInfoUpdateCallbackList.add(callback)
        }

        // 模拟事件触发
        Observable
            .interval(1, TimeUnit.SECONDS)
            .take(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                val userInfo = UserManager.currentUser?.let {
                    it.experience += 10
                    it
                }
                for (item in userInfoUpdateCallbackList) {
                    item.onUserInfoUpdate(GsonUtil.toJson(userInfo))
                }
            })
    }

    override fun requestUserInfoUpdate(): Observable<String> {
        val userInfo = UserManager.currentUser?.let {
            it.experience += 10
            it
        }

        // 模拟网络请求
        return Observable
            .timer(300L + Random.nextInt(700), TimeUnit.MILLISECONDS)
            .map {
                GsonUtil.toJson(userInfo)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}