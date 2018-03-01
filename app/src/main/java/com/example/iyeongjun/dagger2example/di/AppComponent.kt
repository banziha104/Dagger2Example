package com.example.iyeongjun.dagger2example.di

import dagger.android.AndroidInjector
import com.example.iyeongjun.dagger2example.App
import dagger.Component

/**
 * Created by iyeongjun on 2018. 3. 1..
 */
@Component(modules = arrayOf(Modules::class))
interface AppComponent : AndroidInjector<App>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}