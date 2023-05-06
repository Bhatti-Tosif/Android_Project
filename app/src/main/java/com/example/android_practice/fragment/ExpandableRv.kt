package com.example.android_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.ExpandableRVAdapter
import com.example.android_practice.adapter.GridLayoutAdapter
import com.example.android_practice.databinding.FragmentExpandableRvBinding
import com.example.android_practice.databinding.FragmentGridManagerBinding
import com.example.android_practice.recycler_view.Constant


class ExpandableRv : Fragment() {

    private lateinit var binding: FragmentExpandableRvBinding

    private lateinit var rvAdapter: ExpandableRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExpandableRvBinding.inflate(layoutInflater)

        rvAdapter = ExpandableRVAdapter(Constant.getExpandData())
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        binding.rvRestaurant.adapter = rvAdapter

        return binding.root
    }
}