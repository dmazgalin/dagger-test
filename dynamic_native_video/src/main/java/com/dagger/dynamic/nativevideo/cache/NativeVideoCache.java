package com.dagger.dynamic.nativevideo.cache;

import com.dagger.corerx.SchedulerConfiguration;
import com.dagger.dynamic.nativevideo.api.NativeVideoAPI;
import com.dagger.dynamic.nativevideo.model.NativeVideoData;

import java.util.List;

import io.reactivex.Maybe;

public class NativeVideoCache {

    private final NativeVideoAPI api;
    private final SchedulerConfiguration scheduler;

    public NativeVideoCache(NativeVideoAPI api, SchedulerConfiguration scheduler) {
        this.api = api;
        this.scheduler = scheduler;
    }

    public Maybe<List<NativeVideoData>> getItems() {
        return Maybe.fromSingle(api.getNativeVideos().subscribeOn(scheduler.getIo()));
    }
}
