package com.example.android_practice.viewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice.R

class ViewvPagerPractice : AppCompatActivity() {

    private lateinit var viewAdapter: ViewPagerAdapter
    private lateinit var dataList: ArrayList<ViewPagerData>
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewv_pager_practice)
        init()
    }

    fun init() {

        viewPager2 = findViewById(R.id.viewPager2)
        dataList = ArrayList<ViewPagerData>()
        setViewPagerData()
        viewAdapter = ViewPagerAdapter(dataList, viewPager2)
        viewPager2.adapter = viewAdapter
        viewPager2.offscreenPageLimit = 1
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
    fun setViewPagerData() {
        dataList.add(ViewPagerData(R.drawable.hotel1, "This is an 5 start hotel"))
        dataList.add(ViewPagerData(R.drawable.restaurant2, "This is an 5 start hotel"))
        dataList.add(ViewPagerData(R.drawable.restaurant, "This is an 3 start hotel"))
        dataList.add(ViewPagerData(R.drawable.hotel1, "This is an 5 start hotel"))
        dataList.add(ViewPagerData(R.drawable.hotel1, "This is an 5 start hotel"))
    }
}