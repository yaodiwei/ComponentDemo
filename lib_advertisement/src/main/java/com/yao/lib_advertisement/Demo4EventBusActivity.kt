package com.yao.lib_advertisement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_base.CallbackStringList
import com.yao.lib_base.LoadUserConfigEvent
import com.yao.lib_base.OpenLoginActivityEvent
import com.yao.lib_base.RouterHub
import com.yao.lib_base.Util.print
import org.greenrobot.eventbus.EventBus

@Route(path = RouterHub.DEMO_4)
class Demo4EventBusActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_simple)

        title = "EventBus 方式调用"

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                EventBus.getDefault().post(OpenLoginActivityEvent())
            }
            R.id.btn_2 -> {
                EventBus.getDefault().post(LoadUserConfigEvent(object : CallbackStringList {
                    override fun onCallback(list: List<String>) {
                        Toast.makeText(this@Demo4EventBusActivity, list.print(), Toast.LENGTH_SHORT).show()
                    }
                }))
            }
        }
    }

}