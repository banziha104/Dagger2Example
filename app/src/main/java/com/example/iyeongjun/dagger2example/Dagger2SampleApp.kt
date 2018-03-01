package com.example.iyeongjun.dagger2example

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
class Dagger2SampleApp : DaggerApplication{
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

    }
}