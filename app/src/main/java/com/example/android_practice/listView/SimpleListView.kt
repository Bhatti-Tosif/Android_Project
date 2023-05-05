package com.example.android_practice.listView

import android.annotation.SuppressLint
import android.content.ComponentCallbacks
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class SimpleListView : AppCompatActivity() {

    private lateinit var tabForList: TabLayout
    private lateinit var idViewpager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        idViewpager = findViewById(R.id.viewPagerForList)
        tabForList = findViewById(R.id.tabForListView)

        val fragmentAdapter = FragmentAdapterForList(this)
        idViewpager.adapter = fragmentAdapter


        tabForList.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { idViewpager.currentItem = it.position  }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        idViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val tab = tabForList.getTabAt(position) ?: return
                return tab.select()
            }
        })

    }


}