package com.example.iyeongjun.dagger2example.rxDi

import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
class RxModule{

    @PerActivity
    @Provides
    fun provideObservable() : PublishSubject<String> = PublishSubject.create()
}