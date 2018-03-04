package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.util.Log.d
import com.example.iyeongjun.dagger2example.mainDi.MsgModel
import com.example.iyeongjun.dagger2example.rxDi.RxModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class MainActivity : DaggerAppCompatActivity(){

    @Inject @field:Named("first") lateinit var msgModel : MsgModel
    @Inject @field:Named("second") lateinit var msgModel2 : MsgModel
    @Inject lateinit var rx : RxModel
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("Main","first : ${msgModel.str} ")
        d("Main","second : ${msgModel2.str} ")
        d("Main","객체값 ${rx.obj}")

        rx.obj.subscribe{
            d("Main","메인에서 받은 값 ${it}")
        }

        btnGoSecond.setOnClickListener{
            startActivity<SecondActivity>()

        }
        btnUpScore.setOnClickListener {
            rx.obj.onNext("${num}")
            num++
        }
    }
}