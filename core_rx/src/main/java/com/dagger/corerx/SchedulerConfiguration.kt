package com.dagger.corerx

import io.reactivex.Scheduler

interface SchedulerConfiguration {
    /**
     * Scheduler for all IO operations (i.e. file access, network requests, etc..)
     */
    val io: Scheduler
    /**
     * Scheduler for computational work (i.e. mapping, heavy math, etc..)
     */
    val computation: Scheduler
    /**
     * Scheduler for UI operations
     */
    val ui: Scheduler
    /**
     * Scheduler for timers
     */
    val timer: Scheduler
}