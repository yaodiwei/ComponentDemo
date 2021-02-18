package com.yao.lib_advertisement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yao.lib_base.RouterHub
import com.yao.lib_base.Util.print

@Route(path = RouterHub.DEMO_2_1)
class Demo2ARouter1Activity : AppCompatActivity(), View.OnClickListener {

    // 使用依赖注入为服务赋值，通过注解标注字段，即可使用，无需主动获取。
    @JvmField
    @Autowired()
    var advertisementServiceInAd: AdvertisementServiceInAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_simple)
        ARouter.getInstance().inject(this);

        title = "ARouter注入方式调用（使用上层模块写实现）"

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                advertisementServiceInAd?.openLoginActivity(this)
            }
            R.id.btn_2 -> {
                val channelList: List<String> = advertisementServiceInAd?.loadUserConfig() ?: emptyList()
                Toast.makeText(this, channelList.print(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
