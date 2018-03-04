package com.example.iyeongjun.dagger2example

import com.example.iyeongjun.dagger2example.mainDi.DaggerMsgComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by iyeongjun on 2018. 3. 3..
 */

class Dagger2ExampleApp : DaggerApplication{
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMsgComponent.builder().setMyContext(this).build()
    }


}