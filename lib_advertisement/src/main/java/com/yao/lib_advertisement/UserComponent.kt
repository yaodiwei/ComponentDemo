package com.yao.lib_advertisement

import com.yao.lib_advertisement.Demo3DaggerActivity
import dagger.Component

@Component(
    modules = [
        UserModule::class
    ]
)
interface UserComponent {
    fun inject(activity: Demo3DaggerActivity)
}