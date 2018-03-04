package com.example.iyeongjun.dagger2example.mainDi

import android.content.Context
import com.example.iyeongjun.dagger2example.Dagger2ExampleApp
import com.example.iyeongjun.dagger2example.MainActivity
import com.example.iyeongjun.dagger2example.subDi.IntComponent
import com.example.iyeongjun.dagger2example.subDi.ToMainComponetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Singleton
@Component(modules = arrayOf(MsgModule::class,ToMainComponetModule::class))
interface MsgComponent : AndroidInjector<Dagger2ExampleApp>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : MsgComponent
    }
}