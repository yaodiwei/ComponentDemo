package com.yao.componentdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.yao.lib_advertisement.AdvertisementGlue
import com.yao.lib_base.LoadUserConfigEvent
import com.yao.lib_base.OpenLoginActivityEvent
import com.yao.lib_base.RouterHub
import com.yao.lib_user.LoginActivity
import com.yao.lib_user.UserManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_4).setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                // 使用到广告模块前，进行胶水的赋值。
                AdvertisementGlue.advertisement = AdvertisementGlueImpl
                ARouter.getInstance().build(RouterHub.DEMO_1).navigation()
            }
            R.id.btn_2_1 -> {
                ARouter.getInstance().build(RouterHub.DEMO_2_1).navigation()
            }
            R.id.btn_2_2 -> {
                ARouter.getInstance().build(RouterHub.DEMO_2_2).navigation()
            }
            R.id.btn_3 -> {
                ARouter.getInstance().build(RouterHub.DEMO_3).navigation()
            }
            R.id.btn_4 -> {
                ARouter.getInstance().build(RouterHub.DEMO_4).navigation()
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: OpenLoginActivityEvent) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: LoadUserConfigEvent) {
        event.callback.onCallback(UserManager.currentUser?.channel ?: emptyList())
    }
}