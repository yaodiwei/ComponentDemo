package com.yao.lib_reader

import dagger.Component

@Component
interface MagicBox {
    fun poke(app: ReaderActivity)
}