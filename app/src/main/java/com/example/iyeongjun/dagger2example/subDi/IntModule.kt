package com.example.iyeongjun.dagger2example.subDi

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@Module
@Singleton
class IntModule{

    @Provides
    @Singleton
    fun provideIntModel() = IntModel(19920816)

}