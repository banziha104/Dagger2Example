package com.example.iyeongjun.dagger2example.mainDi

import com.example.iyeongjun.dagger2example.Dagger2ExampleApp
import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@PerActivity
@Subcomponent(modules = arrayOf(MsgModule::class))
interface MsgComponent : AndroidInjector<Dagger2ExampleApp>{

    @Subcomponent.Builder
    interface Builder{

        fun build() : MsgComponent
    }
}