package com.example.iyeongjun.dagger2example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.iyeongjun.dagger2example.mainDi.DaggerMsgComponent
import com.example.iyeongjun.dagger2example.subDi.IntModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {
    @Inject lateinit var intModel: IntModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

}
