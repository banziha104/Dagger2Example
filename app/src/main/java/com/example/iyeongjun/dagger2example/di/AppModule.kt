package com.example.iyeongjun.dagger2example.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
class AppModule{
    @Provides
    @Named("appContext")
    @Singleton
    fun provideContext(application: Application) : Context = application.applicationContext
}