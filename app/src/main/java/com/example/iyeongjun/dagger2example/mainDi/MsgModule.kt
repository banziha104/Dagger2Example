package com.example.iyeongjun.dagger2example.mainDi

import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Module
class MsgModule {

    @Provides
    @Named("first")
    @PerActivity
    fun provideMsgModel() : MsgModel = MsgModel("이게 첫번쨰")

    @Provides
    @Named("second")
    @PerActivity
    fun provideMsgModelOther() : MsgModel = MsgModel("이건 두번째")
}