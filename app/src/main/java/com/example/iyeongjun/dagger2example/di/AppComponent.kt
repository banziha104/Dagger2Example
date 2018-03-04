package com.example.iyeongjun.dagger2example.di

import android.content.Context
import com.example.iyeongjun.dagger2example.Dagger2ExampleApp
import com.example.iyeongjun.dagger2example.mainDi.MsgSubMoudle
import com.example.iyeongjun.dagger2example.rxDi.RxModule
import com.example.iyeongjun.dagger2example.subDi.IntSubModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Singleton
@Component(modules = arrayOf(ActivityBinder::class,AndroidSupportInjectionModule::class,AppModule::class,MsgSubMoudle::class,IntSubModule::class,RxModule::class))
interface AppComponent : AndroidInjector<Dagger2ExampleApp>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : AppComponent
    }
}