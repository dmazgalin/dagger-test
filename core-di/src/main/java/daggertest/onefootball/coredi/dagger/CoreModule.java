package daggertest.onefootball.coredi.dagger;

import com.dagger.core.picasso.PicassoLoader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {
    @Provides
    PicassoLoader providePicassoLoader(Picasso picasso) {
        return new PicassoLoader(picasso);
    }
}
