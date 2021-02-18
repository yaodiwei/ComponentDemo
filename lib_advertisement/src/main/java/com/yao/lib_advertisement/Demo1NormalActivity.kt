package com.yao.lib_advertisement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_base.RouterHub
import com.yao.lib_base.Util.print
import org.greenrobot.eventbus.EventBus

class Demo1NormalActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_simple)

        title = "正常的（无添加的）调用"

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                AdvertisementGlue.openLoginActivity(this)
            }
            R.id.btn_2 -> {
                val channelList: List<String> = AdvertisementGlue.loadUserConfig()
                Toast.makeText(this, channelList.print(), Toast.LENGTH_LONG).show()
            }
        }
    }

}