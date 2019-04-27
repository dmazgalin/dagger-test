package com.dagger.corecontext.dagger;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context applicationContext;

    public ContextModule(Application application) {
        applicationContext = application.getApplicationContext();
    }

    @Provides
    public Context providesContext() {
        return applicationContext;
    }

}
