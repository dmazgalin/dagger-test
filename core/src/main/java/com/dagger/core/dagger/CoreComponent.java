package com.dagger.core.dagger;

import com.dagger.core.picasso.PicassoLoader;

import dagger.Component;

@Component(modules = {CoreModule.class, PicassoModule.class})
public interface CoreComponent {
    PicassoLoader providePicassoLoader();
}
