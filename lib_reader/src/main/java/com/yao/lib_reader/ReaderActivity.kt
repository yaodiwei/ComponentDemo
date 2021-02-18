package com.yao.lib_reader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class ReaderActivity: AppCompatActivity() {

    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMagicBox.create().poke(this)
    }
}