package com.dagger.test.dagger;

import com.dagger.test.MainActivity;

import dagger.Component;
import daggertest.onefootball.coredi.dagger.CoreComponent;

@Component(dependencies = CoreComponent.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
