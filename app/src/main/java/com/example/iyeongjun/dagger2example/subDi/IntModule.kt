package com.example.iyeongjun.dagger2example.subDi

import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Module
import dagger.Provides


/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@Module
class IntModule{
    @Provides
    @PerActivity
    fun provideIntModel() = IntModel(19920816)
}