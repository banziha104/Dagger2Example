package com.example.iyeongjun.dagger2example.rxDi

import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
class RxModule{

    @Provides
    @Singleton
    fun provideObservable() : RxModel = RxModel(PublishSubject.create())
}