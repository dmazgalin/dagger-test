package com.dagger.corerx

import dagger.Module
import dagger.Provides

@Module
class RxModule {
    @Provides
    fun providesSchedulerConfiguration() : SchedulerConfiguration = SchedulerConfigurationImpl
}
