package com.dagger.corerx

import dagger.Module
import dagger.Provides

@Module
class CoreRxModule {
    @Provides
    fun providesSchedulerConfiguration() : SchedulerConfiguration = SchedulerConfigurationImpl
}
