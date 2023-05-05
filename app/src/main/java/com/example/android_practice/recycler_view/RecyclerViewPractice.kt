package com.example.android_practice.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityImageButtonBinding
import com.example.android_practice.databinding.ActivityRecyclerViewPracticeBinding
import com.example.android_practice.fragment.FragmentAdapterForRv
import com.example.android_practice.fragment.FragmentAdapterForWp
import com.google.android.material.tabs.TabLayout

class RecyclerViewPractice : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentAdapter = FragmentAdapterForRv(this, binding.tabForRv.tabCount)
        binding.viewPager2.adapter = fragmentAdapter

        binding.tabForRv.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { binding.viewPager2.currentItem = it.position }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val tab = binding.tabForRv.getTabAt(position) ?: return
                tab.select()
            }
        })
    }
}