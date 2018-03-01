package com.example.iyeongjun.dagger2example

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Module
class MsgModule {
    @Singleton
    @Provides
    fun provideMsgModel() : MsgModel = MsgModel("알다가도 모르겠는 대거")
}