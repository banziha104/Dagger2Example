package com.example.iyeongjun.dagger2example.rxDi

import com.example.iyeongjun.dagger2example.di.PerActivity
import dagger.Subcomponent


/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@PerActivity
@Subcomponent
interface RxComponent{

    @Subcomponent.Builder
    interface Builder {
        fun build() : RxComponent
    }
}