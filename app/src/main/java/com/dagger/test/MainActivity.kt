package com.dagger.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagger.core.picasso.PicassoLoader
import com.dagger.test.adapter.CmsAdapter
import com.dagger.test.model.CmsItem
import com.dagger.test.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var picassoLoader: PicassoLoader

    private lateinit var cmsAdapter: CmsAdapter

    private lateinit var model : MainViewModel
    private lateinit var observer : Observer<List<CmsItem>>

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                cmsRecycler.visibility = View.GONE
                nativeVideo.visibility = View.GONE
                textMessage.setText(R.string.title_home)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                cmsRecycler.visibility = View.VISIBLE
                nativeVideo.visibility = View.GONE
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                cmsRecycler.visibility = View.GONE
                nativeVideo.visibility = View.VISIBLE
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent().inject(this)

        cmsRecycler.visibility = View.GONE
        nativeVideo.visibility = View.GONE

        cmsAdapter = CmsAdapter(picassoLoader)
        observer = Observer { items -> cmsAdapter.setCmsItems(items) }
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        model.cmsLiveData.observe(this, observer)

        cmsRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        cmsRecycler.adapter = cmsAdapter

        nativeVideo.setOnClickListener { model.onNativeVideoClick() }

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onResume() {
        super.onResume()

    }
}
