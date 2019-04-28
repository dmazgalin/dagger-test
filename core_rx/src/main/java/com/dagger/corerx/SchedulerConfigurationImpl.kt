package com.dagger.corerx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal object SchedulerConfigurationImpl : SchedulerConfiguration {
    override val io: Scheduler = Schedulers.io()
    override val computation: Scheduler = Schedulers.computation()
    override val ui: Scheduler = AndroidSchedulers.mainThread()
    override val timer: Scheduler = Schedulers.computation()
}