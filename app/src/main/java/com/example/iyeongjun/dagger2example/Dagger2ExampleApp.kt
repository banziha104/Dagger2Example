package com.example.iyeongjun.dagger2example

import com.example.iyeongjun.dagger2example.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by iyeongjun on 2018. 3. 3..
 */

class Dagger2ExampleApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().setMyContext(this).build()
    }


}