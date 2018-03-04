package com.example.iyeongjun.dagger2example.di

import com.example.iyeongjun.dagger2example.MainActivity
import com.example.iyeongjun.dagger2example.SecondActivity
import com.example.iyeongjun.dagger2example.mainDi.MsgModule
import com.example.iyeongjun.dagger2example.subDi.IntModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
abstract class ActivityBinder{
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MsgModule::class,IntModule::class))
    abstract fun bindMainActivity() : MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(IntModule::class))
    abstract fun bindSecondActivity() : SecondActivity
}