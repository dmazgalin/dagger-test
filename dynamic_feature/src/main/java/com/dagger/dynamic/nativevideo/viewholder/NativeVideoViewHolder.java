package com.dagger.dynamic.nativevideo.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.dynamic.nativevideo.R;

public class NativeVideoViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image;
    public final TextView title;

    public NativeVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.native_video_image);
        title = itemView.findViewById(R.id.native_video_title);
    }
}
