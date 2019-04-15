package com.dagger.dynamic.nativevideo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.dagger.dynamic.nativevideo.cache.NativeVideoCache;

public class NativeVideoViewModel extends AndroidViewModel {

    //TODO: inject cache
    NativeVideoCache cache;

    public NativeVideoViewModel(@NonNull Application application) {
        super(application);
    }

    public void getNativeVideoItems() {

    }
}
