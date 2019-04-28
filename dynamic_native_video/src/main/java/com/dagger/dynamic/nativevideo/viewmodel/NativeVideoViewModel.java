package com.dagger.dynamic.nativevideo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dagger.dynamic.nativevideo.cache.NativeVideoCache;
import com.dagger.dynamic.nativevideo.model.NativeVideoItem;

import java.util.List;

public class NativeVideoViewModel extends AndroidViewModel {

    //TODO: inject cache
    NativeVideoCache cache;

    MutableLiveData<List<NativeVideoItem>> nativeVideoItemMutableLiveData;

    public NativeVideoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<NativeVideoItem>> getNativeVideoItems() {
        if (nativeVideoItemMutableLiveData == null) {
            nativeVideoItemMutableLiveData = new MutableLiveData<>();
        }

        return nativeVideoItemMutableLiveData;
    }
}
