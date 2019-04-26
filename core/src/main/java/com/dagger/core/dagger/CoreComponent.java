package com.dagger.core.dagger;

import com.dagger.core.picasso.PicassoLoader;

import com.dagger.corehttp.dagger.CoreHttpModule;
import dagger.Component;

@Component(modules = {CoreModule.class, PicassoModule.class, CoreHttpModule.class})
public interface CoreComponent {
    PicassoLoader providePicassoLoader();
}
