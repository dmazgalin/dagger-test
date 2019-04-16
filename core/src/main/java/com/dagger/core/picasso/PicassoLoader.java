package com.dagger.core.picasso;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoLoader {

    Picasso picasso;

    public PicassoLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    public void loadImage(String url, ImageView imageView) {
        picasso.load(url).into(imageView);
    }
}
