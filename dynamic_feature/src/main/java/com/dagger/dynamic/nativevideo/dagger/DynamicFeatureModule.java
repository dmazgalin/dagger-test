package com.dagger.dynamic.nativevideo.dagger;

import com.dagger.corerx.SchedulerConfiguration;
import com.dagger.dynamic.nativevideo.api.NativeVideoAPI;
import com.dagger.dynamic.nativevideo.cache.NativeVideoCache;
import com.dagger.dynamic.nativevideo.viewmodel.ViewModelFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class DynamicFeatureModule {
    @Provides
    ViewModelFactory providesViewModelFactory(NativeVideoCache cache, SchedulerConfiguration schedulerConfiguration) {
        return new ViewModelFactory(cache, schedulerConfiguration);
    }

    @Provides
    NativeVideoCache providesNativeVideoCache(NativeVideoAPI api, SchedulerConfiguration schedulerConfiguration) {//
        return new NativeVideoCache(api, schedulerConfiguration);
    }

    @Provides
    NativeVideoAPI providesNativeVideoApi(Retrofit retrofit) {
        return retrofit.create(NativeVideoAPI.class);
    }
}
