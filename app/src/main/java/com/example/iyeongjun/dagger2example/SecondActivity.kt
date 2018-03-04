package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.util.Log.d
import com.example.iyeongjun.dagger2example.rxDi.RxModel
import com.example.iyeongjun.dagger2example.subDi.IntModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {
    @Inject lateinit var intModel: IntModel
    @Inject lateinit var rx : RxModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        d("Main","${intModel.num} 출력")
        d("Main","객체값 ${rx.obj}")
        rx.obj.subscribe {
            d("Main", "SecondActivity${it}")
        }
        btnFinish.setOnClickListener{
            rx.obj.onNext("finish")
            finish()
        }

    }

}
