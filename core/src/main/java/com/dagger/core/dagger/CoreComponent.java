package com.dagger.core.dagger;

import com.dagger.core.picasso.PicassoLoader;
import com.dagger.corecontext.dagger.ContextModule;
import com.dagger.corehttp.dagger.CoreHttpModule;
import com.dagger.corerx.CoreRxModule;

import dagger.Component;

@Component(modules = {CoreModule.class, PicassoModule.class, CoreHttpModule.class, ContextModule.class, CoreRxModule.class})
public interface CoreComponent {
    PicassoLoader providePicassoLoader();
}
