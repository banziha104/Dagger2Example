package com.example.iyeongjun.dagger2example

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Singleton
@Component(modules = arrayOf(MsgModule::class))
interface MsgComponent{
    fun inject(injected : MainActivity)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : MsgComponent
    }
}