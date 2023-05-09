package com.example.android_practice.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapterForRv(fragmentActivity: FragmentActivity, var tabCount: Int): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> LinearManager()
            1 -> GridManager()
            2 -> StaggeredLayoutManager()
            3 -> SearchRecyclerView()
            4 -> ExpandableRv()
            5 -> SwappableRv()
            6 -> MultipleHolderRv()
            else -> LinearManager()
        }
    }
}