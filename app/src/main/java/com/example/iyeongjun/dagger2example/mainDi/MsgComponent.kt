package com.example.iyeongjun.dagger2example.mainDi

import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Subcomponent

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@PerActivity
@Subcomponent(modules = arrayOf(MsgModule::class))
interface MsgComponent{

    @Subcomponent.Builder
    interface Builder{

        fun build() : MsgComponent
    }
}