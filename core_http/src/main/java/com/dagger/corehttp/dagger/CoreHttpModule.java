package com.dagger.corehttp.dagger;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CoreHttpModule {

    private static final long HTTP_CACHE_SIZE = 15 * 1024 * 1024;
    private static final String CORE_HTTP = "core-http";

    @Provides
    OkHttpClient providesOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.addInterceptor(httpLoggingInterceptor);
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

    @Provides
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(" ").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

    }

    @Provides
    Gson providesGson() {
        return new GsonBuilder().setLenient().create();
    }
}
