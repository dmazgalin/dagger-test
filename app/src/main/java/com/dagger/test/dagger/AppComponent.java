package com.dagger.test.dagger;

import com.dagger.core.dagger.CoreComponent;
import com.dagger.test.MainActivity;

import dagger.Component;

@Component(dependencies = CoreComponent.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
