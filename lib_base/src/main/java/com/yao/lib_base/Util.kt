package com.yao.lib_base

object Util {

    fun kotlin.collections.List<String>.print(): String {
        var sb = StringBuilder()
        for (str in this) {
            sb.append(str).append(", ")
        }
        return sb.toString()
    }
}