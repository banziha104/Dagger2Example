package com.example.iyeongjun.dagger2example.subDi

import com.example.iyeongjun.dagger2example.SecondActivity
import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Subcomponent

/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@PerActivity
@Subcomponent(modules = arrayOf(IntModule::class))
interface IntComponent{
    fun inject2(subActivity: SecondActivity)

    @Subcomponent.Builder
    interface Builder{
        fun build() : IntComponent
    }
}