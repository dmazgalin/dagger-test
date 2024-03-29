package daggertest.onefootball.coredi.dagger;

import android.content.Context;
import com.squareup.picasso.Cache;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class PicassoModule {
    @Provides
    Picasso providesPicasso(Context context, OkHttp3Downloader downloader, Cache memoryCache) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.memoryCache(memoryCache);
        builder.downloader(downloader);
        return builder.build();
    }

    @Provides
    Cache providesMemoryCache(Context context) {
        return new LruCache(context);
    }

    @Provides
    OkHttp3Downloader providesHttpDownloader(OkHttpClient client) {
        return new OkHttp3Downloader(client);
    }
}
