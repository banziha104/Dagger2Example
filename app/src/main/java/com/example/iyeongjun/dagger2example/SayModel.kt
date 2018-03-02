package com.example.iyeongjun.dagger2example

import android.util.Log

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

class SayModel(val msg : MsgModel ,val str : String){
    fun sayMyName(){
        Log.d("MainActivity","새마넴 ${msg.str}  / ${str} ")
    }
}