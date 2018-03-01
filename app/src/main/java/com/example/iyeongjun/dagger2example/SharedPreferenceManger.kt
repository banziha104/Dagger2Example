package com.example.iyeongjun.dagger2example

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class SharedPreferenceManger @Inject constructor( mainActivity: MainActivity){

    private lateinit var sharedPreference : SharedPreferences

    init {
        sharedPreference = mainActivity.getSharedPreferences("demo", Context.MODE_PRIVATE)
    }

    fun setName(name : String){
        sharedPreference.edit().putString("Name",name).apply()
    }

    fun getName(): String {
        return sharedPreference.getString("name","default")
    }
}