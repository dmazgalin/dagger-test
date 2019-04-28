package com.dagger.dynamic.nativevideo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dagger.corerx.SchedulerConfiguration;
import com.dagger.dynamic.nativevideo.cache.NativeVideoCache;
import com.dagger.dynamic.nativevideo.model.NativeVideoData;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class NativeVideoViewModel extends ViewModel {

    private final SchedulerConfiguration scheduler;
    private NativeVideoCache cache;

    MutableLiveData<List<NativeVideoData>> nativeVideoItemMutableLiveData;

    CompositeDisposable disposable;

    public NativeVideoViewModel(NativeVideoCache cache, SchedulerConfiguration scheduler) {
        this.cache = cache;
        this.scheduler = scheduler;
    }

    public LiveData<List<NativeVideoData>> getNativeVideoItems() {
        if (nativeVideoItemMutableLiveData == null) {
            nativeVideoItemMutableLiveData = new MutableLiveData<>();
        }

        return nativeVideoItemMutableLiveData;
    }

    public void activityResumed() {
        disposable.add(cache.getItems().subscribeOn(scheduler.getComputation()).observeOn(scheduler.getUi()).subscribe(nativeVideoData -> {
            nativeVideoItemMutableLiveData.postValue(nativeVideoData);
        }, throwable -> {
            Timber.e(throwable, "activityResumed()");
        }));
    }

    public void activityPaused() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
