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
    fun provideMsgModel() : MsgModel = MsgModel("알다가도 모르겠는 가")

    @Provides
    @Named("second")
    @PerActivity
    fun provideMsgModelOther() : MsgModel = MsgModel("네임 써본 대거")
}