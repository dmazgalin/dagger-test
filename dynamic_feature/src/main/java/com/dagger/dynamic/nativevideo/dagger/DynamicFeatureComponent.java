package com.dagger.dynamic.nativevideo.dagger;

import com.dagger.core.dagger.CoreComponent;
import com.dagger.corecontext.dagger.ContextModule;
import com.dagger.corehttp.dagger.CoreHttpModule;
import com.dagger.corerx.CoreRxModule;
import com.dagger.dynamic.nativevideo.DynamicFeatureActivity;

import dagger.Component;

@Component(dependencies = CoreComponent.class, modules = {DynamicFeatureModule.class, CoreRxModule.class, CoreHttpModule.class, ContextModule.class})
public interface DynamicFeatureComponent {
    void inject(DynamicFeatureActivity activity);
}
