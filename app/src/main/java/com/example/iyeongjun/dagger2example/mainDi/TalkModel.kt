package com.example.iyeongjun.dagger2example.mainDi

import android.util.Log

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

class TalkModel(val msg : MsgModel, val str2: String){
    fun speek(){
        Log.d("MainActivity","say ${msg.str} / ${str2}")
    }
}