package com.dagger.corehttp.dagger;

import android.content.Context;
import com.squareup.picasso.OkHttp3Downloader;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import java.io.File;

@Module
public class CoreHttpModule {

    private static final long HTTP_CACHE_SIZE = 1000;
    private static final String CORE_HTTP = "core-http";

    @Provides
    OkHttp3Downloader providesHttpDownloader(OkHttpClient client) {
        return new OkHttp3Downloader(client);
    }

    @Provides
    OkHttpClient providesOkHttpClient(Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        //builder.addNetworkInterceptor(null);
        return builder.build();
    }

    @Provides
    Cache providesCache(File cacheDirectory) {
        return new Cache(cacheDirectory, HTTP_CACHE_SIZE);
    }

    @Provides
    File providesFile(Context context) {
        return new File(context.getCacheDir(), CORE_HTTP);
    }
}
