package com.example.iyeongjun.dagger2example.di

import com.example.iyeongjun.dagger2example.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 1..
 */

@Singleton
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}