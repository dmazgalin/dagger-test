package com.dagger.dynamic.nativevideo.dagger;

import com.dagger.core.dagger.CoreComponent;
import com.dagger.dynamic.nativevideo.NativeVideoActivity;

import dagger.Component;

@Component(dependencies = CoreComponent.class, modules = NativeVideoModule.class)
public interface NativeVideoComponent {
    void inject(NativeVideoActivity activity);
}
