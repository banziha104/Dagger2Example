package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

class MainActivity : AppCompatActivity(){

    @Inject lateinit var sharedPreferenceManager : SharedPreferenceManger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferenceManager.setName("dagger test")
        val name = sharedPreferenceManager.getName()
    }
}