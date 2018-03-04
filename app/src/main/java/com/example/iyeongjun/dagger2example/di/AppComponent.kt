package com.example.iyeongjun.dagger2example.di

import android.content.Context
import com.example.iyeongjun.dagger2example.Dagger2ExampleApp
import com.example.iyeongjun.dagger2example.mainDi.MsgSubMoudle
import com.example.iyeongjun.dagger2example.rxDi.RxSubModule
import com.example.iyeongjun.dagger2example.subDi.IntSubModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Component(modules = arrayOf(ActivityBinder::class, AndroidSupportInjectionModule::class,AppModule::class,RxSubModule::class,MsgSubMoudle::class,IntSubModule::class))
interface AppComponent : AndroidInjector<Dagger2ExampleApp>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : AppComponent
    }
}