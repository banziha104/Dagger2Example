package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class MainActivity : AppCompatActivity(){

    @Inject @field:Named("first") lateinit var msgModel : MsgModel
    @Inject @field:Named("second") lateinit var msgModel2 : MsgModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMsgComponent.builder().setMyContext(this).build().inject(injected = this)

        Log.d("Main","${msgModel.str} 이 호출이 되더냐")
        Log.d("Main","${msgModel2.str} 자아아아알 되더냐")
        
    }
}