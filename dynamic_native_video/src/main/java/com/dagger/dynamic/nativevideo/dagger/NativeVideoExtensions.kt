package com.dagger.dynamic.nativevideo.dagger

import android.app.Activity
import com.dagger.test.DTApplication
import com.dagger.test.coreComponent

fun Activity.nativeVideoComponent() = DaggerNativeVideoComponent.builder().coreComponent((this.applicationContext as DTApplication).coreComponent()).build()