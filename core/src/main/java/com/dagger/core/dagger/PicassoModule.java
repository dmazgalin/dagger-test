package com.dagger.core.dagger;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {
    @Provides
    Picasso providesPicasso() {
        return Picasso.get();
    }
}
