package com.example.android_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.MultipleHolderAdapter
import com.example.android_practice.databinding.FragmentMultipleHolderRvBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.HotelData

class MultipleHolderRv : Fragment() {

    private lateinit var binding: FragmentMultipleHolderRvBinding
    private lateinit var multipleAdapter: MultipleHolderAdapter

    private lateinit var hotelDataList: ArrayList<HotelData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMultipleHolderRvBinding.inflate(inflater)

        hotelDataList = Constant.getHotelData()

        multipleAdapter = MultipleHolderAdapter(hotelDataList)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        binding.rvRestaurant.adapter = multipleAdapter

        return binding.root
    }

}