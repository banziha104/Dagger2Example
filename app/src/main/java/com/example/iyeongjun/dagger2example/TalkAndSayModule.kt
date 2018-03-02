package com.example.iyeongjun.dagger2example

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Module
class TalkAndSayModule{
    @Provides
    @Named("firstTalk")
    @Singleton
    fun provideTalkModel1(@Named("first") msgModel: MsgModel, context: Context) : TalkModel = TalkModel(msg = msgModel, str2 = "첫 번째 퇔 모델")

    @Provides
    @Named("secondTalk")
    @Singleton
    fun provideTalkModel2(@Named("second") msgModel: MsgModel) : SayModel = SayModel(msg = msgModel , str = "이영준")
}