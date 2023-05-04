package com.example.android_practice.fragment

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.GridLayoutAdapter
import com.example.android_practice.databinding.FragmentGridManagerBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.RvAdapter

class GridManager : Fragment() {

    private lateinit var binding: FragmentGridManagerBinding

    private lateinit var rvAdapter: GridLayoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGridManagerBinding.inflate(layoutInflater)

        rvAdapter = GridLayoutAdapter(Constant.getData())
        binding.rvRestaurant.layoutManager = GridLayoutManager(container?.context, 2)
        binding.rvRestaurant.adapter = rvAdapter

        return binding.root
    }
}