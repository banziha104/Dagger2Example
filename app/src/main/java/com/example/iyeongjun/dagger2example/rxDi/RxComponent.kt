package com.example.iyeongjun.dagger2example.rxDi

import dagger.Subcomponent
import javax.inject.Singleton


/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Singleton
@Subcomponent
interface RxComponent{

    @Subcomponent.Builder
    interface Builder {
        fun build() : RxComponent
    }
}