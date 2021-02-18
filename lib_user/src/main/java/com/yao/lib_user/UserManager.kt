package com.yao.lib_user

object UserManager {

    var currentUser: UserInfo? = null
        get() {
            if (field == null) {
                field = UserInfo(3233, "Yao")
                field?.channel = mutableListOf("book", "movie", "music")
                field?.vipLevel = 2
            }
            return field
        }

}