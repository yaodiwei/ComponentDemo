package com.yao.lib_advertisement

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.yao.lib_base.RouterHub
import com.yao.lib_base.UserDaggerService
import com.yao.lib_base.Util.print
import javax.inject.Inject

@Route(path = RouterHub.DEMO_3)
class Demo3DaggerActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var userDaggerService: UserDaggerService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_simple)
        DaggerUserComponent.create().inject(this)

        title = "Dagger注入方式调用（失败）"

        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> {
                userDaggerService.openLoginActivity(this)
            }
            R.id.btn_2 -> {
                val channelList: List<String> = userDaggerService.loadUserConfig()
                Toast.makeText(this, channelList.print(), Toast.LENGTH_LONG).show()
            }
        }
    }

}
