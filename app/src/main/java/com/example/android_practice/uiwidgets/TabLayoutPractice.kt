package com.example.android_practice.uiwidgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityTabLayoutPracticeBinding
import com.example.android_practice.fragment.FragmentAdapterForWp
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutPractice : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabLayoutPracticeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tabLayoutWp.addTab(binding.tabLayoutWp.newTab().setText("Chat"))
        binding.tabLayoutWp.addTab(binding.tabLayoutWp.newTab().setText("Status"))
        binding.tabLayoutWp.addTab(binding.tabLayoutWp.newTab().setText("Call"))
        binding.tabLayoutWp.tabGravity = TabLayout.GRAVITY_FILL

        binding.tabLayoutWp.setBackgroundColor(getColor(R.color.btn_color))

        val fragmentAdapter = FragmentAdapterForWp(this, supportFragmentManager, binding.tabLayoutWp.tabCount)
        binding.viewPager.adapter = fragmentAdapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutWp))

        val tab1 = binding.tabLayoutWp.getTabAt(0)

        binding.tabLayoutWp.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { binding.viewPager.currentItem = it.position }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}