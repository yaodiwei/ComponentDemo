package com.yao.lib_base

class OpenLoginActivityEvent() {

}

class LoadUserConfigEvent(var callback: CallbackStringList) {

}


// 各种回调 -------------------------
interface CallbackInt {
    fun onCallback(int :Int)
}

interface CallbackString {
    fun onCallback(string :String)
}

interface CallbackStringList {
    fun onCallback(list :List<String>)
}