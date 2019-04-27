package com.dagger.test

import android.app.Activity

fun DTApplication.coreComponent() = DTApplication.coreComponent(this)
fun Activity.appComponent() = DTApplication.appComponent(this)