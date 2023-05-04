package com.example.android_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.StaggeredAdapter
import com.example.android_practice.databinding.FragmentStaggeredLayoutManagerBinding
import com.example.android_practice.recycler_view.Constant

class StaggeredLayoutManager : Fragment() {

    private lateinit var binding: FragmentStaggeredLayoutManagerBinding
    private lateinit var rvAdapter: StaggeredAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStaggeredLayoutManagerBinding.inflate(layoutInflater)

        rvAdapter = StaggeredAdapter(Constant.getData())
        binding.rvRestaurant.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvRestaurant.adapter = rvAdapter

        return binding.root
    }
}