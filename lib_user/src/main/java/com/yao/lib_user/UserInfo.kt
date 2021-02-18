package com.yao.lib_user

data class UserInfo(
    val id: Long,
    val name: String
) {
    var channel: MutableList<String>? = null
    var vipLevel: Int = 0
    var experience: Int = 0
}