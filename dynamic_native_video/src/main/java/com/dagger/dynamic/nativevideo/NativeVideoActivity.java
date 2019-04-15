package com.dagger.dynamic.nativevideo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.core.picasso.PicassoLoader;
import com.dagger.dynamic.nativevideo.adapter.NativeVideoAdapter;
import com.dagger.dynamic.nativevideo.viewmodel.NativeVideoViewModel;

public class NativeVideoActivity extends AppCompatActivity {

    //TODO: inject it from app
    PicassoLoader picassoLoader;

    NativeVideoViewModel model;

    NativeVideoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_native_video);

        adapter = new NativeVideoAdapter(picassoLoader);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        RecyclerView recyclerView = findViewById(R.id.native_video_recycler);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        model.getNativeVideoItems();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
