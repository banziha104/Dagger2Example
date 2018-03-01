package com.example.iyeongjun.dagger2example

import dagger.Component
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
@Singleton
@Component(modules = arrayOf(MsgModule::class))
interface MsgComponent{
    fun makeMsgModle() : MsgModel
}