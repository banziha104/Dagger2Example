package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class MainActivity : DaggerAppCompatActivity(){
    @Inject lateinit var msgModel : MsgModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMsgComponent.builder().setMyContext(this).build()
        Log.d("Main","${msgModel.str} 이 호출이 되더냐")
    }
}