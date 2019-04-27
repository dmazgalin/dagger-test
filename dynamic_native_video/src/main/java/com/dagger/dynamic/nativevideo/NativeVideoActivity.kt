package com.dagger.dynamic.nativevideo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagger.core.picasso.PicassoLoader
import com.dagger.dynamic.nativevideo.adapter.NativeVideoAdapter
import com.dagger.dynamic.nativevideo.dagger.nativeVideoComponent
import com.dagger.dynamic.nativevideo.viewmodel.NativeVideoViewModel
import javax.inject.Inject

class NativeVideoActivity : AppCompatActivity() {

    @Inject
    lateinit var picassoLoader: PicassoLoader

    private lateinit var model: NativeVideoViewModel

    private lateinit var adapter: NativeVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_native_video)

        nativeVideoComponent().inject(this)

        adapter = NativeVideoAdapter(picassoLoader)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val recyclerView = findViewById<RecyclerView>(R.id.native_video_recycler)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        model = ViewModelProviders.of(this).get(NativeVideoViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        model.getNativeVideoItems()
    }

    override fun onPause() {
        super.onPause()
    }
}
