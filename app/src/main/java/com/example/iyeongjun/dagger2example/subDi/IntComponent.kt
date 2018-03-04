package com.example.iyeongjun.dagger2example.subDi

import android.content.Context
import com.example.iyeongjun.dagger2example.MainActivity
import com.example.iyeongjun.dagger2example.SecondActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@Subcomponent(modules = arrayOf(IntModule::class))
interface IntComponent{
    fun inject2(subActivity: SecondActivity)

    @Subcomponent.Builder
    interface Builder{
        fun build() : IntComponent
    }
}