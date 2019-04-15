package com.dagger.test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.core.picasso.PicassoLoader;
import com.dagger.test.R;
import com.dagger.test.model.CmsItem;
import com.dagger.test.viewholder.CmsViewHolder;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CmsAdapter extends RecyclerView.Adapter {

    List<CmsItem> items = new ArrayList<>();
    PicassoLoader picassoLoader;

    public CmsAdapter(PicassoLoader picassoLoader) {
        this.picassoLoader = picassoLoader;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cms_item, viewGroup, false);
        return new CmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CmsViewHolder) {

            CmsItem item = items.get(i);
            CmsViewHolder nativeVideoViewHolder = (CmsViewHolder) viewHolder;

            picassoLoader.loadImage(item.cmsThumbnail, nativeVideoViewHolder.image);
            nativeVideoViewHolder.title.setText(item.cmsTitle);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setCmsItems(@Nullable List<CmsItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}
