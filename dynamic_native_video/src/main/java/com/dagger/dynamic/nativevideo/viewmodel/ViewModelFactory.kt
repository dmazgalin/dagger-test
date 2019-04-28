package com.dagger.dynamic.nativevideo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dagger.corerx.SchedulerConfiguration

import com.dagger.dynamic.nativevideo.cache.NativeVideoCache
import com.dagger.dynamic.nativevideo.dagger.NativeVideoModule

class ViewModelFactory(private val cache: NativeVideoCache, private val schedulerConfiguration: SchedulerConfiguration) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NativeVideoModule::class.java)) {
            return NativeVideoViewModel(cache, schedulerConfiguration) as T
        }
        throw IllegalArgumentException("View model factory has no support for this type")
    }
}
