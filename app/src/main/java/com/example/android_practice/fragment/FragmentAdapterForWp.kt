package com.example.android_practice.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapterForWp(var myContext: Context, var fm: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fm, totalTabs) {

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return ChatFragment()
            1 -> return  StatusFragment()
            2 -> return  CallFragment()
            else -> null
        }
        return Fragment()
    }

}