package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.util.Log
import com.example.iyeongjun.dagger2example.subDi.IntModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {
    @Inject lateinit var intModel: IntModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("Second","${intModel.num} 이 바뀌었습니까")
    }

}
