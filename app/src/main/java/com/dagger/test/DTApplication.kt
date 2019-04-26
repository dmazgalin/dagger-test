package com.dagger.test

import android.app.Application
import android.content.Context
import com.dagger.core.dagger.CoreComponent
import com.dagger.core.dagger.DaggerCoreComponent
import com.dagger.corecontext.dagger.ContextModule


class DTApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder().contextModule(ContextModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()

        //Timber.i("Application created");
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context): CoreComponent {
            return (context.applicationContext as DTApplication).coreComponent
        }
    }
}
