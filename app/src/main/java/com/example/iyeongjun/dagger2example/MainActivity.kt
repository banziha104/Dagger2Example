package com.example.iyeongjun.dagger2example

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.util.Log.v
import com.example.iyeongjun.dagger2example.mainDi.MsgModel
import com.example.iyeongjun.dagger2example.subDi.IntModel
import com.example.iyeongjun.dagger2example.subDi.IntModule
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class MainActivity : DaggerAppCompatActivity(){

    @Inject @field:Named("first") lateinit var msgModel : MsgModel
    @Inject @field:Named("second") lateinit var msgModel2 : MsgModel
    @Inject lateinit var intModel: IntModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("Main","${msgModel.str} 이 호출이 되더냐")
        d("Main","${msgModel2.str} 자아아아알 되더냐")
        d("Main","${intModel.num} 은 십")

        intModel.num = 30

        btnGoSecond.setOnClickListener{
            startActivity<SecondActivity>()
        }
    }
}