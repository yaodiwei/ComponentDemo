package com.yao.lib_advertisement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yao.lib_base.*
import com.yao.lib_base.Util.print
import io.reactivex.functions.Consumer

@Route(path = RouterHub.DEMO_2_2)
class Demo2ARouter2Activity : AppCompatActivity(), View.OnClickListener {

    // 使用依赖注入为服务赋值，通过注解标注字段，即可使用，无需主动获取。
    @JvmField
    @Autowired()
    var advertisementServiceInBase: AdvertisementServiceInBase? = null

    @JvmField
    @Autowired()
    var userService: UserService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_complex)
        ARouter.getInstance().inject(this);

        title = "ARouter注入方式调用（使用下层模块写接口）"

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_4).setOnClickListener(this)
        findViewById<Button>(R.id.btn_5).setOnClickListener(this)
        findViewById<Button>(R.id.btn_6).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                advertisementServiceInBase?.openLoginActivity(this)
            }
            R.id.btn_2 -> {
                val channelList: List<String> = advertisementServiceInBase?.loadUserConfig() ?: emptyList()
                Toast.makeText(this, channelList.print(), Toast.LENGTH_LONG).show()
            }
            R.id.btn_3 -> {
                val level = userService?.getVipLevel() ?: 0
                Toast.makeText(this, "会员等级：$level", Toast.LENGTH_LONG).show()
            }
            R.id.btn_4 -> {
                userService?.openVipActivity(this)
            }
            R.id.btn_5 -> {
                userService?.registerUserInfoUpdate(userInfoUpdateCallback)
            }
            R.id.btn_6 -> {
                userService
                    ?.requestUserInfoUpdate()
                    ?.subscribe {
                        Toast.makeText(
                            this@Demo2ARouter2Activity,
                            "请求用户信息更新：$it",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
    }

    private val userInfoUpdateCallback = object : UserInfoUpdateCallback {
        override fun onUserInfoUpdate(jsonString: String) {
            Toast.makeText(this@Demo2ARouter2Activity, "用户信息更新回调：$jsonString", Toast.LENGTH_SHORT).show()
        }
    }
}
