package com.example.android_practice.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_practice.fragment.BottomDownloadFragment
import com.example.android_practice.fragment.BottomHomeFragment
import com.example.android_practice.fragment.BottomProfileFragment

class AdapterForBottomNavigation(fragmentActivity: FragmentActivity, val tabCount: Int): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BottomHomeFragment()
            1 -> BottomDownloadFragment()
            2 -> BottomProfileFragment()
            else -> BottomHomeFragment()
        }
    }
}