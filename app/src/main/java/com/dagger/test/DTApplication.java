package com.dagger.test;

import android.app.Application;


public class DTApplication extends Application {

    DaggerAppComponent daggerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
