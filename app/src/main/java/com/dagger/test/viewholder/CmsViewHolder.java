package com.dagger.test.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.test.R;


public class CmsViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image;
    public final TextView title;

    public CmsViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.cms_image);
        title = itemView.findViewById(R.id.cms_title);
    }
}
