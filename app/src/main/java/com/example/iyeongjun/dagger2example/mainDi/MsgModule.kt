package com.example.iyeongjun.dagger2example.mainDi

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Module
class MsgModule {

    @Provides
    @Named("first")
    @Singleton
    fun provideMsgModel() : MsgModel = MsgModel("알다가도 모르겠는 가")

    @Provides
    @Named("second")
    @Singleton
    fun provideMsgModelOther() : MsgModel = MsgModel("네임 써본 대거")
}