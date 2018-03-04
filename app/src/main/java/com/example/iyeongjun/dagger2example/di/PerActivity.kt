package com.example.iyeongjun.dagger2example.di

import javax.inject.Scope

/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity

