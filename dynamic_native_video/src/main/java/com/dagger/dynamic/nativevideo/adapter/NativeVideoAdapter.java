package com.dagger.dynamic.nativevideo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.core.picasso.PicassoLoader;
import com.dagger.dynamic.nativevideo.R;
import com.dagger.dynamic.nativevideo.model.NativeVideoItem;
import com.dagger.dynamic.nativevideo.viewholder.NativeVideoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NativeVideoAdapter extends RecyclerView.Adapter {

    List<NativeVideoItem> items = new ArrayList<>();
    PicassoLoader picassoLoader;

    public NativeVideoAdapter(PicassoLoader picassoLoader) {
        this.picassoLoader = picassoLoader;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.native_video_item, viewGroup, false);
        return new NativeVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof NativeVideoViewHolder) {

            NativeVideoItem item = items.get(i);
            NativeVideoViewHolder nativeVideoViewHolder = (NativeVideoViewHolder) viewHolder;

            picassoLoader.loadImage(item.videoThumbnail, nativeVideoViewHolder.image);
            nativeVideoViewHolder.title.setText(item.videoTitle);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
