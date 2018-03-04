package com.example.iyeongjun.dagger2example.subDi

import dagger.Module

/**
 * Created by iyeongjun on 2018. 3. 2..
 */

@Module(subcomponents = arrayOf(IntComponent::class))
class ToMainComponetModule