package com.dagger.dynamic.nativevideo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagger.core.picasso.PicassoLoader
import com.dagger.dynamic.nativevideo.adapter.NativeVideoAdapter
import com.dagger.dynamic.nativevideo.dagger.nativeVideoComponent
import com.dagger.dynamic.nativevideo.model.NativeVideoData
import com.dagger.dynamic.nativevideo.viewmodel.NativeVideoViewModel
import com.dagger.dynamic.nativevideo.viewmodel.ViewModelFactory
import javax.inject.Inject

class DynamicFeatureActivity : AppCompatActivity() {

    @Inject
    lateinit var picassoLoader: PicassoLoader
    @Inject
    lateinit var factory : ViewModelFactory

    private lateinit var model: NativeVideoViewModel

    private lateinit var adapter: NativeVideoAdapter

    private lateinit var observer: Observer<List<NativeVideoData>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_native_video)

        nativeVideoComponent().inject(this)

        model = ViewModelProviders.of(this, factory).get(NativeVideoViewModel::class.java)
        adapter = NativeVideoAdapter(picassoLoader)
        observer = Observer { items -> adapter.setNativeVideoItems(items) }

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val recyclerView = findViewById<RecyclerView>(R.id.native_video_recycler)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        model.nativeVideoItems.observe(this, observer)
    }

    override fun onResume() {
        super.onResume()

        model.activityResumed()
    }

    override fun onPause() {
        super.onPause()

        model.activityPaused()
    }
}
